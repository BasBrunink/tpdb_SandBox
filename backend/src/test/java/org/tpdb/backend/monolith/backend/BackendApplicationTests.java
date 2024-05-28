package org.tpdb.backend.monolith.backend;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {

  @Test
  void contextLoads() {
    int exp = 1;
    int act = 1;
    assertEquals(exp, act);
  }

}
