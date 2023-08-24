package Social.Controllers;

import Social.Model.People;
import io.micrometer.common.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public List<People> index(int limit,String name) {
        List<People> people=new ArrayList<People>();
        people.add(new People("dominos",123));
        people.add(new People("lox",321));
        var list=people.stream();
        if(limit>0)
            list=list.limit(limit);
        if(!StringUtils.isEmpty(name))
            list=list.filter(x-> x.Name.equals(name));
        return list.collect(Collectors.toList());
    }

}