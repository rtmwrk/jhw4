import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    //--- Функциональное позитивное тестирование --------------
    //--- Реализация метода проверки эквивалентных значений ---

    // Тест расчета бонуса для зарегистрированного в системе пользователя
    // и значением цены билета до лимитного значения
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    // Тест расчета бонуса для зарегистрированного в системе пользователя
    // и значением цены билета сверх лимитного значения
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    // Тест расчета бонуса для незарегистрированного в системе пользователя
    // и значением цены билета до лимитного значения
    @Test
    void shouldCalculateForUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    // Тест расчета бонуса для незарегистрированного в системе пользователя
    // и значением цены билета сверх лимитного значения
    @Test
    void shouldCalculateForUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    //--- Функциональное позитивное тестирование --------------
    //--- Реализация метода проверки граничных значений ---

    // Тест расчета бонуса для зарегистрированного в системе пользователя
    // и значением цены билета равной лимитному значению, т.е. bonus = limit.
    // amount должен быть равен 16 667, что приведет к bonus = 500
    @Test
    void shouldCalculateForRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16_667;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    // Тест расчета бонуса для незарегистрированного в системе пользователя
    // и значением цены билета равной лимитному значению, т.е. bonus = limit.
    // amount должен быть равен 50000, что приведет к bonus = 500
    @Test
    void shouldCalculateForUnRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 50000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}