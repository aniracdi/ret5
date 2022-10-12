package com.usa.proyectoReto3.Service;

import com.usa.proyectoReto3.Model.Admin;
import com.usa.proyectoReto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(validarCampos(admin)) {
            if (admin.getIdAdmin() == null) {
                return adminRepository.save(admin);
            } else {
                Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
                if (adminEncontrado.isEmpty()) {
                    return adminRepository.save(admin);
                } else {
                    return admin;
                }
            }
        }
        return admin;
    }
    public Admin update(Admin admin){
        if(validarCampos(admin)) {
            if (admin.getIdAdmin() != null) {
                Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
                if (!adminEncontrado.isEmpty()) {
                    if (admin.getPassword() != null) {
                        adminEncontrado.get().setPassword(admin.getPassword());
                    }
                    if (admin.getName() != null) {
                        adminEncontrado.get().setName(admin.getName());
                    }
                    return adminRepository.save(adminEncontrado.get());
                }
            }
            return admin;
        }
        return admin;
    }

    public boolean delete (int id){
        Boolean resultado = getAdmin(id).map(elemento ->{
            adminRepository.delete(elemento);
            return true;
        }).orElse(false);
        return resultado;
    }

    public boolean validarCampos(Admin admin){
        return (admin.getEmail().length() <= 45 && admin.getName().length()>=45 && admin.getPassword().length()>= 45);
    }
}
