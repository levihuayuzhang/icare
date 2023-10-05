package org.ph1nix.icare.patient.hotel.service.impl;

import org.ph1nix.icare.patient.hotel.mapper.HotelMapper;
import org.ph1nix.icare.patient.hotel.pojo.Hotel;
import org.ph1nix.icare.patient.hotel.service.IHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
