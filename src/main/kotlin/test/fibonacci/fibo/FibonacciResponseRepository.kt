package test.fibonacci.fibo
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FibonacciResponseRepository : MongoRepository<FibonacciResponseEntity,String>{
}