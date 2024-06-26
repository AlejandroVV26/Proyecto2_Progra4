package org.example.proyecto2_progra4.controller.restController;
/*
import cr.ac.una.invoicessystem.data.dto.ClientFormDto;
import cr.ac.una.invoicessystem.data.dto.ProductFormDto;
import cr.ac.una.invoicessystem.data.dto.ServiceFormDto;
import cr.ac.una.invoicessystem.data.entities.*;
import cr.ac.una.invoicessystem.data.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class GeneralApplication {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final MeasureUnitRepository measureUnitRepository;
    private final ProductRepository productRepository;
    private final UserProductRepository userProductRepository;
    private final ServiceRepository serviceRepository;
    private final UserServiceRepository userServiceRepository;

    public GeneralApplication(UserRepository userRepository,
                              ClientRepository clientRepository,
                              MeasureUnitRepository measureUnitRepository,
                              ProductRepository productRepository,
                              UserProductRepository userProductRepository,
                              ServiceRepository serviceRepository,
                              UserServiceRepository userServiceRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.measureUnitRepository = measureUnitRepository;
        this.productRepository = productRepository;
        this.userProductRepository = userProductRepository;
        this.serviceRepository = serviceRepository;
        this.userServiceRepository = userServiceRepository;
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        System.out.println(user.map(Objects::toString).orElse(null));
        return user.map(x -> ResponseEntity.ok().body(x)).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    private ResponseEntity<User> updateUserEnable(@PathVariable int id, @RequestBody User user) {
        Optional<User> userOptional = userRepository.findByNaturalIdAndPassword(user.getNaturalId(), user.getPassword());
        if (userOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        userOptional.get().setName(user.getName());
        userOptional.get().setLastName(user.getLastName());
        userOptional.get().setEmail(user.getEmail());
        userOptional.get().setMobile(user.getMobile());
        userRepository.save(userOptional.get());

        return ResponseEntity.ok().body(userOptional.get());
    }

    @PostMapping("/client")
    private ResponseEntity<Client> addClient(@RequestBody ClientFormDto client, UriComponentsBuilder ucb) {
        //Validations
        Optional<User> userOptional = userRepository.findById(client.getSupplierId());
        if(userOptional.isEmpty()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        //Valid input
        Client clientToSave = Client.builder()
                .naturalId(client.getNaturalId())
                .name(client.getName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .mobile(client.getMobile())
                .build();

        userOptional.get().addClient(clientToSave);
        Client savedClient = clientRepository.save(clientToSave);
        URI locationOfNewClient = ucb
                .path("/client/{id}")
                .buildAndExpand(clientToSave.getId())
                .toUri();

        return ResponseEntity.created(locationOfNewClient).body(savedClient);
    }

    @GetMapping("/client/{id}")
    private ResponseEntity<Client> getClient(@PathVariable Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.map(client ->
                ResponseEntity.ok().body(client)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @GetMapping("/measures")
    private ResponseEntity<List<MeasureUnit>> getAllMeasureUnits() {
        List<MeasureUnit> measuresPage = measureUnitRepository.findAll();
        return ResponseEntity.ok().body(measuresPage);
    }

    @PostMapping("/product")
    private ResponseEntity<Product> addProduct(@RequestBody ProductFormDto product, UriComponentsBuilder ucb) {
        //Validations
        Optional<User> userOptional = userRepository.findById(product.getSupplierId());
        if(userOptional.isEmpty()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        Optional<MeasureUnit> optionalMeasureUnit = measureUnitRepository.findById(product.getMeasureUnit().id());
        if(optionalMeasureUnit.isEmpty()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        //Valid input
        Product productToSave = Product.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        optionalMeasureUnit.get().addProduct(productToSave);
        Product savedProduct = productRepository.save(productToSave);
        URI locationOfNewProduct = ucb
                .path("/product/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();

        UserProduct userProduct = new UserProduct();
        userProduct.setId(new UserProductId(savedProduct.getId(), userOptional.get().getId()));

        if(userOptional.get().getProducts() == null) userOptional.get().setProducts(new HashSet<>());
        if(savedProduct.getUsers() == null) savedProduct.setUsers(new HashSet<>());

        userOptional.get().addUserProduct(userProduct);
        savedProduct.addUserProduct(userProduct);

        userProductRepository.save(userProduct);

        return ResponseEntity.created(locationOfNewProduct).body(savedProduct);
    }

    @PostMapping("/service")
    private ResponseEntity<Service> addService(@RequestBody ServiceFormDto service, UriComponentsBuilder ucb) {
        //Validations
        if(service.getName() == null ||
                service.getPrice() == null ||
                service.getPrice() <= 0 ||
                service.getSupplierId() == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        Optional<User> userOptional = userRepository.findById(service.getSupplierId());
        if(userOptional.isEmpty()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        //Valid input
        Service serviceToSave = Service.builder()
                .name(service.getName())
                .priceHour(service.getPrice())
                .build();

        Service savedService = serviceRepository.save(serviceToSave);
        URI locationOfNewService = ucb
                .path("/service/{id}")
                .buildAndExpand(savedService.getId())
                .toUri();

        UserService userService = new UserService();
        userService.setId(new UserServiceId(savedService.getId(), userOptional.get().getId()));

        if(userOptional.get().getServices() == null) userOptional.get().setServices(new HashSet<>());
        if(savedService.getUsers() == null) savedService.setUsers(new HashSet<>());

        userOptional.get().addUserService(userService);
        savedService.addUserService(userService);

        userServiceRepository.save(userService);

        return ResponseEntity.created(locationOfNewService).body(savedService);
    }
}*/
