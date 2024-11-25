package com.example;


import org.mockito.Mockito;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;


    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, lion.getKittens());

    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertEquals("Некорректный список еды", expectedFood, lion.getFood());
    }

    @Test
    public void testConstructIncorrectSexValue() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "Incorrect");
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
