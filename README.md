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
