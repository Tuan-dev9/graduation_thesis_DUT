package com.ces.hospitalcare.service.impl;
import com.ces.hospitalcare.dto.ConversationDTO;
import com.ces.hospitalcare.entity.ConversationEntity;
import com.ces.hospitalcare.repository.ConversationRepository;
import com.ces.hospitalcare.service.IConversationService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationServiceImpl implements IConversationService {
  @Autowired
  private ModelMapper mapper;

  @Autowired
  private ConversationRepository conversationRepository;

  public List<ConversationDTO> createListConversationDTO(
      List<ConversationEntity> conversationEntityList) {
    List<ConversationDTO> conversationDTOList = new ArrayList<>();

    for (ConversationEntity entity : conversationEntityList) {
      ConversationDTO dto = mapper.map(entity, ConversationDTO.class);

      conversationDTOList.add(dto);
    }

    return conversationDTOList;
  }

  @Override
  public List<ConversationDTO> getAllConversationOfSender(Long senderId) {
    return createListConversationDTO(conversationRepository.getAllBySenderId(senderId));
  }
}
