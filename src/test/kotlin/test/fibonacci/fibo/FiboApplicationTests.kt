package test.fibonacci.fibo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FiboApplicationTests {

	private val testSample: FibonacciResource = FibonacciResource()

	@Test
	fun contextLoads() {
	}
}
