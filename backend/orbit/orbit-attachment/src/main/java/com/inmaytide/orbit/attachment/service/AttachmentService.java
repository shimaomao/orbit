package com.inmaytide.orbit.attachment.service;

import com.inmaytide.orbit.attachment.dao.AttachmentRepository;
import com.inmaytide.orbit.attachment.enums.AttachmentStatus;
import com.inmaytide.orbit.commons.service.BasicService;
import com.inmaytide.orbit.attachment.domain.Attachment;

import java.util.Optional;

public interface AttachmentService extends BasicService<AttachmentRepository, Attachment, Long> {

    /**
     * Use the primary key to get the attachment instance
     *
     * @param id primary key
     * @return instance of attachment class
     */
    Optional<Attachment> get(Long id);

    /**
     * Use the primary key and status to get the attachment instance
     *
     * @param id     primary key
     * @param status the attachment status
     * @return instance of attachment class
     * @see AttachmentStatus
     */
    Optional<Attachment> getByStatus(Long id, AttachmentStatus status);

    /**
     * Add a temporary attachment instance to the cache,
     * use {@link AttachmentService#formal(Long)} or {@link AttachmentService#formal(Attachment)}
     * to change to a formal instance,
     * and if it does not, it will be deleted after 24 hours.
     *
     * @param inst a temporary attachment instance needs to add
     * @see AttachmentService#formal(Long)
     * @see AttachmentService#formal(Attachment)
     * @see com.inmaytide.orbit.attachment.service.impl.AttachmentServiceImpl#TEMPORARY_TIMEOUT_HOURS
     */
    Attachment insert(Attachment inst);

    Attachment formal(Long id);

    Attachment formal(Attachment inst);

    void remove(Long id);

    void remove(Attachment inst);

    void remove(String ids);

    void removeByBelong(String ids);
}
