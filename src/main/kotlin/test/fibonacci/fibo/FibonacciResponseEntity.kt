package test.fibonacci.fibo
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.bson.types.ObjectId

@Document
class FibonacciResponseEntity(numRequest : Int, responseFibo : Int){
    @Id
    var id : ObjectId = ObjectId.get()
}