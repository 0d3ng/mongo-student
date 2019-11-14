package apiakademiksample.mongo.service;

import apiakademiksample.mongo.entitas.Parkir;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
public class ParkirServiceTests {
    @Autowired
    private ParkirService service;

    @Test
    void saveTest() {
        Parkir parkir = new Parkir();
        parkir.setKodeGate("0101");
        parkir.setKodeGerbang("01");
        parkir.setNoKendaraan("AB 2039 YQ");
        parkir.setStatus(true);
        parkir.setTanggalCreated(new Date());
        parkir.setTanggalTransaksi(new Date());
        String save = service.save(parkir);
    }

    @Test
    @Ignore
    void getAllTest() {
        try {
            Parkir parkir = service.getById("5dcca46f76b99a6d2d86088c");
            log.info(parkir.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
