// Java config based configuration is a style of configuration where the configuration is specified with Java code.
// The following are the classes used in Java config based configuration:
//  1. Configuration class is used to declare beans.
//  2. Bean class is used to define a bean.
//  3. @Bean annotation is used to declare a bean.
//  4. @Autowired annotation is used to inject dependencies.
//  5. @Service annotation is used to mark a class as a service.
//  6. @Repository annotation is used to mark a class as a repository.
//  7. @Component annotation is used to mark a class as a component.
//  8. @Qualifier annotation is used to resolve ambiguity when more than one bean of the same type is declared.
//  9. @Primary annotation is used to give higher preference to a bean when more than one bean of the same type is declared.
// 10. @Scope annotation is used to define the scope of a bean.
// 11. @PostConstruct annotation is used to perform some operations after bean initialization.
// 12. @PreDestroy annotation is used to perform some operations before bean destruction.
// 13. @Value annotation is used to inject values into fields.
// 14. @PropertySource annotation is used to load properties from a file.
// 15. @ConfigurationProperties annotation is used to map properties to a class.
// 16. @Import annotation is used to import other configuration classes.
// 17. @ImportResource annotation is used to import XML configuration files.
// 18. @ComponentScan annotation is used to scan for components, services, and repositories.

@Configuration
public class AppConfig
{
    @Bean
    public UserService userService(UserDao dao){
        return new UserService(dao);
    }
    @Bean
    public UserDao userDao(DataSource dataSource){
        return new JdbcUserDao(dataSource);
    }
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("secret");
        return dataSource;
    }
}