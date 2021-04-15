package cicd.demo.svc1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/data/{dataId}")
    public String getData(@PathVariable String dataId) {
        String res = "";

        if (dataId.equals("data11")) {
            res = "data111";
        } else if (dataId.equals("data12")) {
            res = "data112";
        } else if (dataId.equals("data13")) {
            res = "data113";
        } else if (dataId.equals("data14")) {
            res = "data114";
        } else if (dataId.startsWith("data2")) {
            res = restTemplate.getForObject("http://demo-svc2/data/" + dataId, String.class, "");
        } else if (dataId.startsWith("data3")) {
            res = restTemplate.getForObject("http://demo-svc3/data/" + dataId, String.class, "");
        }

        return res;
    }
}
