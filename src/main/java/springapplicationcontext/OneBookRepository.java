package springapplicationcontext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class OneBookRepository implements BookRepository {
}
