package mao.spring_mvc_redirection_and_forwarding;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Project name(项目名称)：Spring_MVC_redirection_and_forwarding
 * Package(包名): mao.spring_mvc_redirection_and_forwarding
 * Class(类名): MyController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/8
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)：
 * 重定向是将用户从当前处理请求定向到另一个视图（例如 JSP）或处理请求，以前的请求（request）中存放的信息全部失效，
 * 并进入一个新的 request 作用域；转发是将用户对当前处理的请求转发给另一个视图或处理请求，以前的 request 中存放的信息不会失效。
 * 转发是服务器行为，重定向是客户端行为。
 * 1）转发过程
 * 客户浏览器发送 http 请求，Web 服务器接受此请求，调用内部的一个方法在容器内部完成请求处理和转发动作，
 * 将目标资源发送给客户；在这里转发的路径必须是同一个 Web 容器下的 URL，其不能转向到其他的 Web 路径上，中间传递的是自己的容器内的 request。
 * 在客户浏览器的地址栏中显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。
 * 2）重定向过程
 * 客户浏览器发送 http 请求，Web 服务器接受后发送 302 状态码响应及对应新的 location 给客户浏览器，
 * 客户浏览器发现是 302 响应，则自动再发送一个新的 http 请求，请求 URL 是新的 location 地址，服务器根据此请求寻找资源并发送给客户。
 * 在这里 location 可以重定向到任意 URL，既然是浏览器重新发出了请求，那么就没有什么 request 传递的概念了。
 * 在客户浏览器的地址栏中显示的是其重定向的路径，客户可以观察到地址的变化。重定向行为是浏览器做了至少两次的访问请求。
 */

@Controller
public class MyController
{
    /**
     * Test 1 string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/test1")
    public String test1(Model model)
    {
        model.addAttribute("message", "默认转发");
        return "main";
    }

    /**
     * Test 2 string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/test2")
    public String test2(Model model)
    {
        model.addAttribute("message", "转发");
        return "forward:/main.jsp";
    }

    /**
     * Tes 3 string.
     *
     * @param session the session
     * @return the string
     */
    @RequestMapping("/test3")
    public String tes3(HttpSession session)
    {
        session.setAttribute("message", "重定向");
        return "redirect:/main.jsp";
    }
}
