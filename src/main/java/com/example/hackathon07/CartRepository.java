@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findByUserId(int userId);
}