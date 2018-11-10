package com.bubletea.bubletea.sample;

import com.bubletea.bubletea.entity.Menu;
import com.bubletea.bubletea.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstUnitTest {
    @Autowired
    MenuService menuService;

    @Test
    public void testAssertArrayEquals() {
//        byte[] expected = "trial".getBytes();
//        byte[] actual = "trial".getBytes();
//        assertArrayEquals("failure - byte arrays not same", expected, actual);
        List<Menu> menus = menuService.getAllMenus();
        int expected = 2;

        assertEquals(expected, menus.size());
    }
}
