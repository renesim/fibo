package test.fibonacci.fibo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.data.annotation.Id

@SpringBootApplication
class FiboApplication

fun main(args: Array<String>) {
	runApplication<FiboApplication>(*args)
}

data class FiboResponse (val closest_fibonacci_number : Int);
data class CounterResponse(val count : Long);
@RestController
class FibonacciResource (private val fibonnaciResponseRepository : FibonacciResponseRepository){
    @GetMapping("api/fibonacci")

    fun GetCloserFibonacci(@RequestParam num : Int) : FiboResponse{
		var row = FibonacciResponseEntity();
		var result = closerToFibonacci(num);
		row.numRequest = num;
		row.responseFibo = result;
		fibonnaciResponseRepository.insert(row)
		return FiboResponse(result);
	}

	@GetMapping("api/request-count")
	fun GetRequestCount() : CounterResponse{
		return CounterResponse((fibonnaciResponseRepository.count()));
	}

	private fun closerToFibonacci(num : Int) : Int{
		var x = 0;
		var y = 1;
		if(num == 0)return 0;
		if(num == 1) return 1;
		while(true){
			var temp = x+y;
			if(num >= y && num <= temp){
				var n1 = num - y;
				var n2 = temp - num;
				if(n1 >= n2){
					return temp;
				}
				else {
					return y;
				}
			}
			x = y;
			y = temp;
		}
	}
}