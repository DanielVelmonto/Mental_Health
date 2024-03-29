package co.com.mentalhealth.apigateway.repository;


import co.com.mentalhealth.apigateway.model.Role;
import co.com.mentalhealth.apigateway.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);

    @Modifying
    @Query("update UserModel set role=:role where username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

    @Modifying
    @Query("update UserModel set password=:pass where username=:username")
    void updateUserPass(@Param("username") String username, @Param("pass") String pass);
}
