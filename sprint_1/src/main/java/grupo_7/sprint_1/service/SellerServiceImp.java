package grupo_7.sprint_1.service;


import grupo_7.sprint_1.dtos.*;
import grupo_7.sprint_1.entity.Buyer;

import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.PostPostDto;
import grupo_7.sprint_1.dtos.SellerDTO;

import grupo_7.sprint_1.entity.Post;
import grupo_7.sprint_1.entity.Seller;
import grupo_7.sprint_1.repository.IBuyerRepository;
import grupo_7.sprint_1.repository.ISellerRepository;
import grupo_7.sprint_1.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SellerServiceImp implements ISellerService {
    ISellerRepository sellerRepository;

    public SellerServiceImp(ISellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public PostDto postPost(Integer sellerId, PostPostDto newPost) {
        isPostValid(newPost);
        Post post = sellerRepository.postPost(sellerId, newPost);
        return Mapper.convertPostToPostDto(post);
    }

    @Override
    public SellerFollowersListDto getListOrderedAlphabetically(Integer userId, boolean orderAsc) {
        Seller seller = sellerRepository.findById(userId);
        List<BuyerDtoRequisito3> listBuyerDto = seller.getFollowers().stream()
                .sorted(orderAsc ? Comparator.comparing(Buyer::getUserName) : Comparator.comparing(Buyer::getUserName).reversed())
                .map(Mapper::convertListToDto)
                .toList();

        return new SellerFollowersListDto(seller.getUserId(), seller.getUserName(), listBuyerDto);
    }

    private void isPostValid(PostPostDto newPost) {
    }
    @Override
    public SellerDTO cantidadSeguidores(int id){
        Seller seller = sellerRepository.findById(id);
        int followersCount = sellerRepository.cantidadDeSeguidores(id);
        return Mapper.convertSellerToSllerDTO(seller, followersCount);
    }
}
