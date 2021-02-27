package io.sam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuweimu
 * @classname XianJiangController
 * @description
 * @date 2020/9/28 14:56
 */
@Slf4j
@RestController
@RequestMapping
public class QingDaoController {

    @PostMapping("/hb-dispatcher/rxsb/v1/system/{shendun}/targets/{id}/search")
    public String getFace(HttpServletResponse response, HttpServletRequest request){
        return "{\"code\":1,\"message\":\"{\\n  \\\"score\\\" : \\\"0.716\\\",\\n  \\\"topNum\\\" : \\\"5\\\",\\n  \\\"feature\\\" : \\\"U09GMUZhAAAQBAAAAAEAAAAAAAAEAAAAAAAAAAAAAAC+XGKCBc9RU5mUE0A4n\\/MWHMxRhN+Qb+GvYb2kSJr9xDfOQj5U16tgpl2TRbIKYiGwT5xt6ASD3Bey\\/t2KgAmknfKdjoLDK6lnu1ghnh1MCylaixMxna2GGihssD4ByVoBgsSZFxKkNEgi3qxpERRxHTueW8E+ejkJgiXaa0\\/HaHwCmgxUtTu\\/3TPbOOYTQEXjpw2bD7OxVUxrMg8PZeeb5vsOdm+C80hhZBJPNViWeydrojhsJvaW8G7EzQxHGe0JweltOQYGKzQ7fZVl6f9kYzDPVH5X71240UI1yNlIkPU+tNZLS7qwZL0qbw6mrbR4FdMWIq0+Jh2dShAbvee8ftXcaUZMQppjTitIK4Ao3tGZfvZyQHhRbSVEtNoq78xOvynuI5Z\\/V9MHbeonEvfPRd2Gstoa0azssMmsudkVR9dKgokVNRDzXy\\/k5XGwznNDK+JlGwmLo\\/k6nGcEVhAcSF0bC9ga+\\/al8O7PEWdcS8I6EHyJs03S2\\/GaafXfzfwWd2Vq\\/\\/vZpmzh99byp2b+KUChAM7uHpS9e1KeyCuIRAQhJofgYOF3WFdBRRqWaYHHtr0Sb5VUDDEEQDK\\/x2NR4LoJXURt3I+rWstC0nLD2z21CbHHJeev910LTT+GXT8cvDL+dC4zI42Qd44Ud4FWaB+4Ovu6ili5qfvSHBaDsuyR3e4lJuN0V3EReCr+RZnVlP1vPVqBE8I6zyJCcvRuYaiP0ZdTdJ6XkYr8OVXnxgigF0fPzuVMx3HDKmvyHRiqFbtLuCKQ6XXUZ8l9EgJxzl7LMIQH6wNsJFxh3exTfm12yTnzTev3JYJatwhobt6sZ00x1GiG0VaxroxPeJTcDcB4vPJBKztFzWma2fsgjTcdbvjNkEgLY6DiGetnL5V+G4MOXLgoObnRp8FN3YlTztGgWoNXanyV8FfCdbMGv0fS3DlhcKl5Fy0NCQ3xEhA2OoxX\\/\\/RTTjezYFmnScQQIm2dYPNT5zq9hrpSyI3tEdsI9vvJuFclSdJ\\/6fb6gFGX9HmOwaThpKmab4fYX5ymkjNV3bBfAl4wBkuyDyhjEslymIvlSKSK8s5zbi4874Phk\\/NbVyd62igC6gNDUap54ZbW4KvKQYVUgQfTY9djmiH\\/1yDZqtroWEko0VQDvwDnRtvLWxhdMHoju5XlJ7IKf1FZ7piaVuYYpMnTHjlOdSqhg28eWEfrien8BHh6cUuImDAHB403lQ\\/5Kasn+QE\\/ywsqc7M\\/aiNfzUv28U6ncR9fDFb6wbpnuvHK1zPPesXhXPlFRGm2LmaQgXMof6iT50xb2o1+ReoaBINLygCgJ2v0Xhmmh6lRBIECr6d7He97yMo16azvHPTh+JCyd8Pn3gMQlZjePJh9aUwFFW1m8w==\\\",\\n  \\\"data\\\" : [ {\\n    \\\"imageId\\\" : \\\"2132214300TTT698469025\\\",\\n    \\\"personName\\\" : \\\"\\u738B\\u798F\\u7965\\\",\\n    \\\"cID\\\" : \\\"370202200105080013\\\",\\n    \\\"sex\\\" : \\\"\\u7537\\\",\\n    \\\"score\\\" : \\\"0.81982154\\\",\\n    \\\"dbId\\\" : \\\"0d2079d4c17348c8aa1524f3ff3812f4\\\",\\n    \\\"pid\\\" : \\\"null\\\"\\n  } ]\\n}\",\"success\":true}";
    }

    @PostMapping("/getTem")
    public String getFace(){
        return "{\"code\":1,\"message\":\"{  \"score\" : \"0.716\",  \"topNum\" : \"5\",  \"feature\" : \"U09GMUZhAAAQBAAAAAEAAAAAAAAEAAAAAAAAAAAAAAC+XGKCBc9RU5mUE0A4n\\/MWHMxRhN+Qb+GvYb2kSJr9xDfOQj5U16tgpl2TRbIKYiGwT5xt6ASD3Bey\\/t2KgAmknfKdjoLDK6lnu1ghnh1MCylaixMxna2GGihssD4ByVoBgsSZFxKkNEgi3qxpERRxHTueW8E+ejkJgiXaa0\\/HaHwCmgxUtTu\\/3TPbOOYTQEXjpw2bD7OxVUxrMg8PZeeb5vsOdm+C80hhZBJPNViWeydrojhsJvaW8G7EzQxHGe0JweltOQYGKzQ7fZVl6f9kYzDPVH5X71240UI1yNlIkPU+tNZLS7qwZL0qbw6mrbR4FdMWIq0+Jh2dShAbvee8ftXcaUZMQppjTitIK4Ao3tGZfvZyQHhRbSVEtNoq78xOvynuI5Z\\/V9MHbeonEvfPRd2Gstoa0azssMmsudkVR9dKgokVNRDzXy\\/k5XGwznNDK+JlGwmLo\\/k6nGcEVhAcSF0bC9ga+\\/al8O7PEWdcS8I6EHyJs03S2\\/GaafXfzfwWd2Vq\\/\\/vZpmzh99byp2b+KUChAM7uHpS9e1KeyCuIRAQhJofgYOF3WFdBRRqWaYHHtr0Sb5VUDDEEQDK\\/x2NR4LoJXURt3I+rWstC0nLD2z21CbHHJeev910LTT+GXT8cvDL+dC4zI42Qd44Ud4FWaB+4Ovu6ili5qfvSHBaDsuyR3e4lJuN0V3EReCr+RZnVlP1vPVqBE8I6zyJCcvRuYaiP0ZdTdJ6XkYr8OVXnxgigF0fPzuVMx3HDKmvyHRiqFbtLuCKQ6XXUZ8l9EgJxzl7LMIQH6wNsJFxh3exTfm12yTnzTev3JYJatwhobt6sZ00x1GiG0VaxroxPeJTcDcB4vPJBKztFzWma2fsgjTcdbvjNkEgLY6DiGetnL5V+G4MOXLgoObnRp8FN3YlTztGgWoNXanyV8FfCdbMGv0fS3DlhcKl5Fy0NCQ3xEhA2OoxX\\/\\/RTTjezYFmnScQQIm2dYPNT5zq9hrpSyI3tEdsI9vvJuFclSdJ\\/6fb6gFGX9HmOwaThpKmab4fYX5ymkjNV3bBfAl4wBkuyDyhjEslymIvlSKSK8s5zbi4874Phk\\/NbVyd62igC6gNDUap54ZbW4KvKQYVUgQfTY9djmiH\\/1yDZqtroWEko0VQDvwDnRtvLWxhdMHoju5XlJ7IKf1FZ7piaVuYYpMnTHjlOdSqhg28eWEfrien8BHh6cUuImDAHB403lQ\\/5Kasn+QE\\/ywsqc7M\\/aiNfzUv28U6ncR9fDFb6wbpnuvHK1zPPesXhXPlFRGm2LmaQgXMof6iT50xb2o1+ReoaBINLygCgJ2v0Xhmmh6lRBIECr6d7He97yMo16azvHPTh+JCyd8Pn3gMQlZjePJh9aUwFFW1m8w==\",  \"data\" : [ {    \"imageId\" : \"2132214300TTT698469025\",    \"personName\" : \"海景房\",    \"cID\" : \"370202200105080013\",    \"sex\" : \"男\",    \"score\" : \"0.81982154\",    \"dbId\" : \"0d2079d4c17348c8aa1524f3ff3812f4\",    \"pid\" : \"null\"  } ]}\",\"success\":true}";
    }

}
