package org.icare.patient.hotel.service.impl;

import org.icare.patient.hotel.mapper.HotelMapper;
import org.icare.patient.hotel.pojo.Hotel;
import org.icare.patient.hotel.service.IHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
