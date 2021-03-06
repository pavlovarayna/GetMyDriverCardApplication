package com.mystique.springdrivercard.services.pictureService;

import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>PictureServiceImpl class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * service layer (reflecting the business requirements of the
 * application) of Picture.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Service
public class PictureServiceImpl implements PictureService {

    private CardApplicationRepository repository;

    @Autowired
    public PictureServiceImpl(CardApplicationRepository cardApplicationRepository) {
        this.repository = cardApplicationRepository;
    }

    @Override
    public Picture getPictureByID(int id) {
        return repository.getPictureByID(id);
    }

    @Override
    public List<Picture> getAllPictures() {
        return repository.getAllPictures();
    }

    @Override
    public Picture addNewPicture(Picture picture) {
        return repository.addNewPicture(picture);
    }

    @Override
    public Picture updatePicture(int id, Picture picture) {
        return repository.updatePicture(id, picture);
    }
}
