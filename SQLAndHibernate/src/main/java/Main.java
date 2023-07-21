import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subscription> query = builder.createQuery(Subscription.class);
        Root<Subscription> root = query.from(Subscription.class);

        List<Subscription> subscriptions = session.createQuery(query).getResultList();

        for (Subscription subscription : subscriptions) {
            LinkedPurchaseListKey key = new LinkedPurchaseListKey();
            key.setStudentId(subscription.getStudentId());
            key.setCourseId(subscription.getCourseId());

            LinkedPurchaseList entity = new LinkedPurchaseList();
            entity.setId(key);

            session.persist(entity);
        }
        transaction.commit();
        session.close();
        registry.close();
    }
}













//        String url = "jdbc:mysql://localhost:3306/skillbox2";
//        String user = "root";
//        String pass = "7.Fuck.7";
//        ArrayList<String> courseNameList = new ArrayList<>();
//        try {
//            Connection connection = DriverManager.getConnection(url, user, pass);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
//
//            while (resultSet.next()){
//                String courseName = resultSet.getString("name");
//                courseNameList.add(courseName);
//            }
//            resultSet.close();
//            for (int i = 0; i < courseNameList.size(); i++){
//                ResultSet resultSetPaid = statement.executeQuery(""+
//                        "SELECT pl.course_name, count(pl.subscription_date)/((max(month(pl.subscription_date)) - min(month(pl.subscription_date)))+ 1) subscription_date\n " +
//                        "FROM PurchaseList pl \n" +
//                        "WHERE pl.course_name = \"" + courseNameList.get(i) + "\" \n" +
//                        "ORDER BY pl.subscription_date;");
//                while (resultSetPaid.next()){
//                    String monthNumber = resultSetPaid.getString("subscription_date");
//                    if (monthNumber == null){
//                        System.out.println("Курс \"" + courseNameList.get(i) + "\" в 2018 году продаж не имел.");
//                    } else {
//                        System.out.println("среднее число продаж в месяц курса \"" + courseNameList.get(i) + "\" в 2018 году равно - " + monthNumber);
//                    }
//                }
//                resultSetPaid.close();
//            }
//            statement.close();
//            connection.close();
//        } catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//}