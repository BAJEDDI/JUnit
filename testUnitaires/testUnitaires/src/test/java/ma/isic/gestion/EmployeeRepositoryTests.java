package ma.isic.gestion;

import java.util.List;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import ma.isic.gestion.Repository.EmployeeRepository;
import ma.isic.gestion.entities.Employee;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit test for saveEmployee

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

    	Employee employee = new Employee("ellon", "musk", "ellon@gmail.com");
    

    	employeeRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }




    
    

    @Test
    @Order(2)
    public void getEmployeeTest(){
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail("amine@gmail.com");

        Assertions.assertThat(optionalEmployee.isPresent()).isTrue();
        
        Employee employee = optionalEmployee.orElse(null);
        
        Assertions.assertThat(employee.getEmail()).isEqualTo("amine@gmail.com");
        
        System.out.println(employee);
    }


    @Test
    @Order(3)
    public void getListOfEmployeesTest() {
        List<Employee> employees = employeeRepository.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

        System.out.println("Liste des employés dans la base de données :");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Prénom: " + employee.getFirstName() +
                    ", Nom: " + employee.getLastName() + ", Email: " + employee.getEmail());
        }
    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = employeeRepository.findById(3L).get();
        System.out.println(employee);
        employee.setEmail("aminemoufid@gmail.com");
        Employee employeeUpdated =  employeeRepository.save(employee);
        System.out.println(employee);

        Assertions.assertThat(employeeUpdated.getEmail()).isEqualTo("aminemoufid@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = employeeRepository.findById(4L).get();

        employeeRepository.delete(employee);

        Assertions.assertThat(employee).isNull();

       

       
    }
}
