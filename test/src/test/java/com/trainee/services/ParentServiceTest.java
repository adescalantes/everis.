package com.trainee.services;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

class ParentServiceTest {

  @Mock
  ParentRepository parentRepository;

  @BeforeEach
  void setUp() throws Exception {

  }

  @Test
  final void testGetAll() {

    Parent parent = new Parent();
    parent.setId(1);
    parent.setFirstName("Alexander");
    when(parentRepository.findById(1)).thenReturn(parent);

  }

}
