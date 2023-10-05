package org.ph1nix.icare.patient.service.impl;

import org.ph1nix.icare.patient.mapper.HotelMapper;
import org.ph1nix.icare.patient.pojo.Hotel;
import org.ph1nix.icare.patient.service.IHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
