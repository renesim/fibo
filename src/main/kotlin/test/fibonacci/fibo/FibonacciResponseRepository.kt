package test.fibonacci.fibo
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface FibonacciResponseRepository : MongoRepository<FibonacciResponseEntity,ObjectId>{
}