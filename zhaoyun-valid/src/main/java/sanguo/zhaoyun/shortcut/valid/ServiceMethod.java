package sanguo.zhaoyun.shortcut.valid;

import org.springframework.stereotype.Service;
import sanguo.zhaoyun.shortcut.valid.controller.RequestParam;

import javax.validation.Valid;

@Service
public class ServiceMethod {
    public void testValid(@Valid RequestParam msgPageRequest){
        System.out.println(msgPageRequest.toString());
    }
}
