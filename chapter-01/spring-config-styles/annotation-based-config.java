// Annotation-based configuration is a style of configuration where the configuration is specified with annotations.
// The following are the annotations used in annotation-based configuration:
//  1. Annotation-based configuration is enabled by @Configuration annotation.
//  2. @Bean annotation is used to declare a bean.
//  3. @Autowired annotation is used to inject dependencies.
//  4. @Service annotation is used to mark a class as a service.
//  5. @Repository annotation is used to mark a class as a repository.
//  6. @Component annotation is used to mark a class as a component.
//  7. @Qualifier annotation is used to resolve ambiguity when more than one bean of the same type is declared.
//  8. @Primary annotation is used to give higher preference to a bean when more than one bean of the same type is declared.
//  9. @Scope annotation is used to define the scope of a bean.
// 10. @PostConstruct annotation is used to perform some operations after bean initialization.
// 11. @PreDestroy annotation is used to perform some operations before bean destruction.
// 12. @Value annotation is used to inject values into fields.
// 13. @PropertySource annotation is used to load properties from a file.
// 14. @ConfigurationProperties annotation is used to map properties to a class.
// 15. @Import annotation is used to import other configuration classes.
// 16. @ImportResource annotation is used to import XML configuration files.
// 17. @ComponentScan annotation is used to scan for components, services, and repositories.


@Service
public class UserService
{
    private final UserDao userDao;
    public UserService(UserDao dao){
        this.userDao = dao;
    }
...
        ...
}
@Repository
public class JdbcUserDao
{
    private final DataSource dataSource;
    public JdbcUserDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
...
        ...
}