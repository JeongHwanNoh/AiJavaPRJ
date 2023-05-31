package kopo.poly.service;


import kopo.poly.dto.NlpDTO;

public interface INlpService {
    NlpDTO getPlainText(String text);
    NlpDTO getNoun(String text);
}
