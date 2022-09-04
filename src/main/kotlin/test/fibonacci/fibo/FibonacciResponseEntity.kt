package test.fibonacci.fibo
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id
import org.bson.types.ObjectId

@Document
public class FibonacciResponseEntity{
    @Id
    var _id : ObjectId = ObjectId.get();
    var numRequest : Int = 0;
    var responseFibo : Int = 0;
}