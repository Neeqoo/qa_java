package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


@RunWith(Parameterized.class)
public class LionParamTest {

    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;

    }

    @Parameterized.Parameters(name = "Класс Lion. Пол:{0}")
    public static Object[][] setSexForLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }


    @Test
    public void testHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals("Ошибка теста на гриву", hasMane, lion.doesHaveMane());
    }
}
