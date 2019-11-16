package apiakademiksample.mongo.dto;

import apiakademiksample.mongo.util.JsonDateTimesSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class ParkirDto {
    private String id;
    private String serial;
    @JsonProperty("kode_gate")
    private String kodeGate;
    @JsonProperty("no_kendaraan")
    private String noKendaraan;
    @JsonProperty("tanggal_transaksi")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalTransaksi;
    @JsonProperty("tanggal_created")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalCreated;
    @JsonProperty("tanggal_expired")
    @JsonDeserialize(using = JsonDateTimesSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tanggalExpired;
    private String summary;
    private boolean status;
}
