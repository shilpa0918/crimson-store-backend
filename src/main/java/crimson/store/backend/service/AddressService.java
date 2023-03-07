package crimson.store.backend.service;

import crimson.store.backend.entity.Address;
import crimson.store.backend.entity.Users;
import crimson.store.backend.repo.AddressRepo;
import crimson.store.backend.repo.UsersRepo;
import crimson.store.backend.request.AddressRequest;
import crimson.store.backend.response.AddressResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    @Autowired
    UsersRepo usersRepo;

    public AddressResponse addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setFirstName(addressRequest.getFirstName());
        address.setLastName(addressRequest.getLastName());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setPinCode(addressRequest.getPinCode());
        address.setState(addressRequest.getState());
        Optional<Users> user = usersRepo.findById(addressRequest.getUserId());
        address.setUsers(user.get());
        Address addedAddress = addressRepo.saveAndFlush(address);
        return convertedToAddressDto(addedAddress);
    }

    private AddressResponse convertedToAddressDto(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setFirstName(address.getFirstName());
        addressResponse.setLastName(address.getLastName());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setPinCode(address.getPinCode());
        addressResponse.setState(address.getState());
        addressResponse.setUserId(address.getUsers().getId());
        return addressResponse;
    }

    public List<AddressResponse> getAddressByUserId(String userId) {
        Optional<Users> users = usersRepo.findById(Integer.valueOf(userId));

        List<Address> addresses = addressRepo.findAddressesByUsersId(users.get().getId());
        List<AddressResponse> addressResponses = addresses.stream().map(address -> {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setCity(address.getCity());
            addressResponse.setCountry(address.getCountry());
            addressResponse.setAddressLine1(address.getAddressLine1());
            addressResponse.setFirstName(address.getFirstName());
            addressResponse.setLastName(address.getLastName());
            addressResponse.setAddressLine2(address.getAddressLine2());
            addressResponse.setPinCode(address.getPinCode());
            addressResponse.setState(address.getState());
            addressResponse.setUserId(address.getUsers().getId());
            return addressResponse;
        }).collect(Collectors.toList());
        return addressResponses;
    }

    public List<AddressResponse> getAddressByUserName(String userName) {
        Users users = usersRepo.findByUserName(userName);
        List<Address> addresses = addressRepo.findAddressesByUsersId(users.getId());
        List<AddressResponse> addressResponses = new ArrayList<>();
        addresses.stream().forEach(address -> {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setCity(address.getCity());
            addressResponse.setCountry(address.getCountry());
            addressResponse.setAddressLine1(address.getAddressLine1());
            addressResponse.setFirstName(address.getFirstName());
            addressResponse.setLastName(address.getLastName());
            addressResponse.setAddressLine2(address.getAddressLine2());
            addressResponse.setPinCode(address.getPinCode());
            addressResponse.setState(address.getState());
            addressResponse.setUserId(address.getUsers().getId());
            addressResponses.add(addressResponse);
        });
        return addressResponses;
    }
}
