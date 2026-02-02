package com._FoundUs.Projekto.domain.repository;


import com._FoundUs.Projekto.domain.model.CommentModel;

import java.util.UUID;

public interface CommentRepo {

    CommentModel save(CommentModel commentModel);
    CommentModel update(UUID id, CommentModel commentModel);
    void delete(UUID id);

}
