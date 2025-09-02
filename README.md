##irlix_elementary

Проект включает в себя решения задач, разработанных для стажировки, 
и предназначен для практического обучения и развития навыков.

В данном репозитории прорабатываются темы:

+ Maven;
+ Git;
+ Spring;
+ Spring Core;
+ Factory Pattern;
+ Spring @annotation;
+ Reflection API.


Также реализован простой меанизм консольной игры в крестики нолики с ботом.
Данный механизм будет дополнен следующими возможностями:
1. Добавление, изменение, удаление пользователей + получение списка пользователей;
2. Регистрация/Авторизация (всё в консоли);
3. Посмотреть статистику по своим играм;
4. Посмотреть топ-10 игроков сыгравших наибольшее количество партий;
5. Для хранения информации использовать:
5.1. Базу данных;
5.2. Коллекции.
6. Покрытие unit-тестами бизнес логику;
7. Также вся логика будет перенесена в разные классы для соблюдения SOLID принципов.

‘’’
package ru.yourcompany.operations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yourcompany.core.operation.AutoInitOperation;
import ru.yourcompany.core.operation.OperationResponse;
import ru.yourcompany.core.request.Request;
import ru.yourcompany.core.transport.MessageExchanger;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class GetCardBalance extends AutoInitOperation<Object> {

    @Autowired
    private MessageExchanger messageExchanger;

    @Autowired
    private QueryExecutor query; // тот же бин, что используется в GetOrdersReport

    @Override
    public OperationResponse defaultValidate(Request rp) {
        // Проверяем, что передан номер карты
        if (rp.getField("cardNumber") == null) {
            return OperationResponse.setError(
                    "Ошибка валидации",
                    "Не указан номер карты"
            );
        }
        return super.defaultValidate(rp, Object.class);
    }

    @Override
    public OperationResponse execute(Request rp) {
        try {
            String cardNumber = rp.getField("cardNumber").toString();

            // SQL для получения баланса по номеру карты
            String sql = "SELECT balance FROM cards WHERE card_number = :cardNumber";
            Map<String, Object> params = Map.of("cardNumber", cardNumber);

            List<Map<String, Object>> result = query.queryList(sql, params, Map.class);

            if (result.isEmpty()) {
                return OperationResponse.setError(
                        "Карта не найдена",
                        "Проверьте правильность номера карты"
                );
            }

            String balance = result.get(0).get("balance").toString();

            // Возвращаем сообщение пользователю
            return OperationResponse.builder()
                    .message("Баланс карты " + cardNumber + ": " + balance + " ₽")
                    .build();

        } catch (Exception e) {
            log.error("Ошибка при получении баланса: ", e);
            return OperationResponse.setError("Ошибка при получении баланса", e.getMessage());
        }
    }
}
‘’’


Описание будет пополняться по мере изучения новых тем.

2025-09-03 09:50:39.365  INFO 14092 --- [io-9678-exec-10] r.d.c.p.PlatformRequestListener          : Received request <?xml version='1.0' encoding='UTF-8'?><Document product="OperationInteraction" user="admin" ver_xml="2016
-05-04" platform="NF" contextId="2f42855e-1b60-4747-bf23-27c525f729dc"><ReqCallOper><operationName>6e435ec4-7bbb-3490-bf4b-2b8ae6015270_ru_dynamika_demo_units_pages_operations_CreditCardTransferMoney</operationName><ObjectId></ObjectId><actionType>default</actionType></ReqCallOper></Document>
2025-09-03 09:50:39.366  INFO 14092 --- [io-9678-exec-10] r.d.core.model.DocumentMarshaller        : Unmarshalling document:
<?xml version='1.0' encoding='UTF-8'?><Document product="OperationInteraction" user="admin" ver_xml="2016-05-04" platform="NF" contextId="2f42855e-1b60-4747-bf23-27c525f729dc"><ReqCallOper><operationName>6e435ec4-7bbb-3490-bf4b-2b8ae6015270_ru_dynamika_demo_units_pages_operations_CreditCardTransferMoney</operationName><ObjectId></ObjectId><actionType>default</actionType></ReqCallOper></Document>
2025-09-03 09:50:39.386 DEBUG 14092 --- [io-9678-exec-10] r.d.core.model.DocumentMarshaller        : Marshalling document: 
<?xml version='1.0' encoding='UTF-8'?><Document product="OperationInteraction" user="admin" platform="NF"><AnsCallOper><AnsReport><ReportList/></AnsReport><DialogBox/><Action>null</Action><LongOperation>0</LongOperation><Percent>0</Percent><FieldProperties/></AnsCallOper></Document>
2025-09-03 09:50:39.386  INFO 14092 --- [io-9678-exec-10] r.d.c.p.PlatformRequestListener          : Answering with <?xml version='1.0' encoding='UTF-8'?><Document product="OperationInteraction" user="admin" platform="NF"><AnsCallOper><AnsReport><ReportList/></AnsReport><DialogBox/><Action>null</Action><LongOperation>0</LongOperation><Percent>0</Percent><FieldProperties/></AnsCallOper></Document>
2025-09-03 09:50:41.499  INFO 14092 --- [nio-9678-exec-1] r.d.c.p.PlatformRequestListener          : Received request <?xml version='1.0' encoding='UTF-8'?><Document product="GET_VIEW_DATA" user="admin" ver_xml="2016-05-04"
 platform="NF" contextId="2f42855e-1b60-4747-bf23-27c525f729dc"><ReqGetData><operation>ru_dynamika_demo_units_pages_operations_CreditCardTransferMoney</operation><class>6e435ec4-7bbb-3490-bf4b-2b8ae6015270</class><param>CREDIT_CARD_SHOW_BALANCE</param><objectId></objectId><params/></ReqGetData></Document>
2025-09-03 09:50:41.499  INFO 14092 --- [nio-9678-exec-1] r.d.core.model.DocumentMarshaller        : Unmarshalling document:
<?xml version='1.0' encoding='UTF-8'?><Document product="GET_VIEW_DATA" user="admin" ver_xml="2016-05-04" platform="NF" contextId="2f42855e-1b60-4747-bf23-27c525f729dc"><ReqGetData><operation>ru_dynamika_demo_units_pages_operations_CreditCardTransferMoney</operation><class>6e435ec4-7bbb-3490-bf4b-2b8ae6015270</class><param>CREDIT_CARD_SHOW_BALANCE</param><objectId></objectId><params/></ReqGetData></Document>
2025-09-03 09:50:41.511 ERROR 14092 --- [nio-9678-exec-1] r.d.c.p.PlatformRequestListener          : Error processing request

ru.dynamika.core.platform_communication.ProcessorException: ╨Ф╨╗╤П ╨╖╨░╨┐╤А╨╛╤Б╨░ ╨╜╨╡ ╨╛╨┐╤А╨╡╨┤╨╡╨╗╤С╨╜ ╨╛╨▒╤А╨░╨▒╨╛╤В╤З╨╕╨║
        at ru.dynamika.core.platform_communication.ReqGetDataProcessorLite.process(ReqGetDataProcessorLite.kt:27) ~[core-api-1.4.215-data-platform-SNAPSHOT.jar!/:na]
        at ru.dynamika.core.platform_communication.PlatformRequestListener.exchange(PlatformRequestListener.kt:29) ~[core-api-1.4.215-data-platform-SNAPSHOT.jar!/:na]
        at ru.dynamika.core.platform_communication.HTTPPlatformRequestListener.listen(XMLHTTPPlatformRequestListener.kt:57) [core-api-1.4.215-data-platform-SNAPSHOT.jar!/:na]
        at sun.reflect.GeneratedMethodAccessor310.invoke(Unknown Source) ~[na:na]
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_441]
        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_441]
        at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) [spring-web-5.3.22.jar!/:5.3.22]
        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) [spring-web-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at javax.servlet.http.HttpServlet.service(HttpServlet.java:681) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) [spring-webmvc-5.3.22.jar!/:5.3.22]
        at javax.servlet.http.HttpServlet.service(HttpServlet.java:764) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) [tomcat-embed-websocket-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) [spring-web-5.3.22.jar!/:5.3.22]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) [spring-web-5.3.22.jar!/:5.3.22]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) [spring-web-5.3.22.jar!/:5.3.22]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) [spring-web-5.3.22.jar!/:5.3.22]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter.doFilterInternal(WebMvcMetricsFilter.java:96) [spring-boot-actuator-2.7.2.jar!/:2.7.2]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) [spring-web-5.3.22.jar!/:5.3.22]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) [spring-web-5.3.22.jar!/:5.3.22]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) [spring-web-5.3.22.jar!/:5.3.22]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:890) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1789) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) [tomcat-embed-core-9.0.65.jar!/:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.65.jar!/:na]
        at java.lang.Thread.run(Thread.java:750) [na:1.8.0_441]

2025-09-03 09:50:41.514 DEBUG 14092 --- [nio-9678-exec-1] r.d.core.model.DocumentMarshaller        : Marshalling document: 
<?xml version='1.0' encoding='UTF-8'?><Document product="GET_VIEW_DATA" user="admin" platform="NF"><Failure><info>╨Ф╨╗╤П ╨╖╨░╨┐╤А╨╛╤Б╨░ ╨╜╨╡ ╨╛╨┐╤А╨╡╨┤╨╡╨╗╤С╨╜ ╨╛╨▒╤А╨░╨▒╨╛╤В╤З╨╕╨║</info><ShowModal>0</ShowModal></Failure></Document>
2025-09-03 09:50:41.514  INFO 14092 --- [nio-9678-exec-1] r.d.c.p.PlatformRequestListener          : Answering with <?xml version='1.0' encoding='UTF-8'?><Document product="GET_VIEW_DATA" user="admin" platform="NF"><Failure><info>╨Ф╨╗╤П ╨╖╨░╨┐╤А╨╛╤Б╨░ ╨╜╨╡ ╨╛╨┐╤А╨╡╨┤╨╡╨╗╤С╨╜ ╨╛╨▒╤А╨░╨▒╨╛╤В╤З╨╕╨║</info><ShowModal>0</ShowModal></Failure></Document>
