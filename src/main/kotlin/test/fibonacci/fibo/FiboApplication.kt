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

data class FiboResponse (val closest_fibonacci_number : Int)

@RestController
class FibonacciResource {
    @GetMapping("api/fibonacci")
	@ResponseBody
    fun GetCloserFibonacci(@RequestParam num : Int) : FiboResponse{
		return FiboResponse(closerToFibonacci(num));
	}

	fun closerToFibonacci(num : Int) : Int{
		var x = 0;
		var y = 1;
		var temp = 1;
		if(num == 0)return 0;
		if(num == 1) return 1;
		while(true){
			temp = x+y;
			if(num >= y && num <= temp){
				println(y)
				println(temp)
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