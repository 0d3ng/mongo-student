package apiakademiksample.mongo.repository;

import apiakademiksample.mongo.entitas.Parkir;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParkirRepository extends PagingAndSortingRepository<Parkir, String> {
}
