package apiakademiksample.mongo.service.impl;

import apiakademiksample.mongo.entitas.Parkir;
import apiakademiksample.mongo.repository.ParkirRepository;
import apiakademiksample.mongo.service.ParkirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkirSeviceImpl implements ParkirService {

    @Autowired
    private ParkirRepository repository;

    @Override
    public Page<Parkir> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Parkir getById(String id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Not Found"));
    }

    @Override
    public String save(Parkir parkir) {
        return repository.save(parkir).getId();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
