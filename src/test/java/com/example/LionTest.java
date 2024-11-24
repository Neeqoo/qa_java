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
        Mockito.when(feline.getKittens()).thenReturn(4);
        int expectedKittens = 4;
        Assert.assertEquals(expectedKittens, lion.getKittens());

    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Мясо");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertEquals("Некорректный список еды", expectedFood, lion.getFood());
    }

    @Test
    public void testTrueDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFalseDoesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testInvalidSex() {
        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion(feline, "Неизвестно");
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
