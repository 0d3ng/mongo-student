package apiakademiksample.mongo.entitas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "parkir")
public class Parkir {
    @Id
    private String id;
    private String serial;
    private String kodeGate;
    private String noKendaraan;
    private Date tanggalTransaksi;
    private Date tanggalCreated;
    private Date tanggalExpired;
    private String summary;
    private boolean status;
}
