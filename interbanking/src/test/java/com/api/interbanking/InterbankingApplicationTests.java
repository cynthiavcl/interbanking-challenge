//package com.api.interbanking;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.api.interbanking.dao.EmpresaRepository;
//import com.api.interbanking.model.Empresa;
//import com.api.interbanking.service.impl.EmpresaServiceImpl;
//
//
////@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//
//class InterbankingApplicationTests {
//	
//    @Mock
//    private EmpresaRepository empresaRepository;
//    
//    @InjectMocks
//    private EmpresaServiceImpl empresaService;
//   
//    
//    Empresa empresa;
//    
//    @BeforeEach
//    public void setUp() {
//        System.out.println("Invoked before each test method");
//        empresa = new Empresa();
//        empresa.setCuit("34-44444-6");
//        empresa.setFechaAdhesion(LocalDate.now());
//        empresa.setRazonSocial("perez sa");
//        empresa.setId(1L);
//    }
//    
//    @Test
//    public void testSave()
//    {
//    	when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);
//    	Empresa empresaSaved = empresaService.crear(new Empresa());
//        assertNotNull(empresaSaved);
//        verify(empresaRepository, times(1)).save(new Empresa());
//    }
//
//	@Test
//	void contextLoads() {
//	}
//
//}
