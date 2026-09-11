-- Remove the existing foreign key constraint
ALTER TABLE `wishlist` DROP FOREIGN KEY `fk_wishlist_on_product`;

-- Add the foreign key constraint with ON DELETE CASCADE
ALTER TABLE `wishlist`
ADD CONSTRAINT fk_wishlist_on_product FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE;