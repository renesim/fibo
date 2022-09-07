package test.fibonacci.fibo
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class FiboApplication

fun main(args: Array<String>) {
	runApplication<FiboApplication>(*args)
}
data class FiboResponse (val closest_fibonacci_number : Int)
data class CounterResponse(val count : Long)
@RestController
class FibonacciResource (private val fibonacciResponseRepository : FibonacciResponseRepository){
	@Operation(summary="Get the closest number between num and fibonacci number ", description ="Return the closest number between num and fibonacci number ")
	@ApiResponses(
		value = [
			ApiResponse(responseCode = "200", description = "Return the closest number between num and fibonacci number"),
		]
	)
    @GetMapping("api/fibonacci")
    fun getCloserFibonacci(@RequestParam num : Int) : FiboResponse{
		try {
			val result = closerToFibonacci(num)
			val row = FibonacciResponseEntity(num, result)
			fibonacciResponseRepository.insert(row)
			return FiboResponse(result)
		}catch(e : IllegalArgumentException){
			throw IllegalArgumentException("Negative number is not allowed.")
		}
	}

	@Operation(summary="Get number of request", description ="Return the number of request by counting the lines")
	@ApiResponses(
		value = [
			ApiResponse(responseCode = "200", description = "Number of lines in history"),
		]
	)
	@GetMapping("api/request-count")
	fun getRequestCount() : CounterResponse{
		return CounterResponse((fibonacciResponseRepository.count()))
	}

	private fun closerToFibonacci(num : Int) : Int{
		if(num < 0) throw IllegalArgumentException()
		var x = 0
		var y = 1
		var temp = x + y
		while(num >= temp){
			x = y
			y = temp
			temp = x+y
		}
		return if(num - y >= temp - num) temp else y
	}
}