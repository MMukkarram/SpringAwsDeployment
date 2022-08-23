package com.spring.aws.deployment.SpringAWSDeployment.repository;

import com.spring.aws.deployment.SpringAWSDeployment.entity.AwsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwsUserRepository extends JpaRepository<AwsUser, Long> {
}
