-- Repeatable migration for seed data
-- This will be run whenever the checksum changes

-- Clear existing data (optional - remove if you want to keep accumulating data)
DELETE FROM products;
DELETE FROM suppliers;

-- Insert sample suppliers
INSERT INTO suppliers (id, name, brand_description, created_by, updated_by) VALUES
    ('550e8400-e29b-41d4-a716-446655440001', 'TechCorp', 'Leading provider of cutting-edge electronics and gadgets', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440002', 'FashionHub', 'Trendy fashion and apparel for modern lifestyle', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440003', 'BeautyPro', 'Premium beauty and skincare products', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440004', 'HomeStyle', 'Quality home and garden essentials', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440005', 'SportMax', 'Sports equipment and outdoor gear', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440006', 'BookWorld', 'Books, media, and entertainment', 'SEED', 'SEED'),
    ('550e8400-e29b-41d4-a716-446655440007', 'FreshMart', 'Organic and gourmet food products', 'SEED', 'SEED');

-- Insert sample products
INSERT INTO products (id, name, category, image_url, price, description, supplier_id, created_by, updated_by) VALUES
    -- Electronics
    ('650e8400-e29b-41d4-a716-446655440001', 'Wireless Bluetooth Headphones', 'ELECTRONICS', 'https://example.com/images/headphones.jpg', 89.99, 'Premium noise-canceling wireless headphones with 30-hour battery life', '550e8400-e29b-41d4-a716-446655440001', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440002', 'Smart Watch Pro', 'ELECTRONICS', 'https://example.com/images/smartwatch.jpg', 299.99, 'Advanced fitness tracking and health monitoring smartwatch', '550e8400-e29b-41d4-a716-446655440001', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440003', '4K Webcam', 'ELECTRONICS', 'https://example.com/images/webcam.jpg', 129.99, 'Crystal clear 4K video conferencing camera with auto-focus', '550e8400-e29b-41d4-a716-446655440001', 'SEED', 'SEED'),
    
    -- Fashion
    ('650e8400-e29b-41d4-a716-446655440004', 'Classic Denim Jeans', 'FASHION', 'https://example.com/images/jeans.jpg', 59.99, 'Comfortable stretch denim jeans in classic blue', '550e8400-e29b-41d4-a716-446655440002', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440005', 'Summer Cotton T-Shirt', 'FASHION', 'https://example.com/images/tshirt.jpg', 24.99, 'Breathable cotton t-shirt available in multiple colors', '550e8400-e29b-41d4-a716-446655440002', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440006', 'Leather Crossbody Bag', 'FASHION', 'https://example.com/images/bag.jpg', 79.99, 'Stylish genuine leather crossbody bag with adjustable strap', '550e8400-e29b-41d4-a716-446655440002', 'SEED', 'SEED'),
    
    -- Beauty
    ('650e8400-e29b-41d4-a716-446655440007', 'Anti-Aging Serum', 'BEAUTY', 'https://example.com/images/serum.jpg', 49.99, 'Powerful anti-aging serum with vitamin C and hyaluronic acid', '550e8400-e29b-41d4-a716-446655440003', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440008', 'Natural Makeup Palette', 'BEAUTY', 'https://example.com/images/palette.jpg', 39.99, '12-color eyeshadow palette with natural and neutral tones', '550e8400-e29b-41d4-a716-446655440003', 'SEED', 'SEED'),
    
    -- Home & Garden
    ('650e8400-e29b-41d4-a716-446655440009', 'Ceramic Planter Set', 'HOME_GARDEN', 'https://example.com/images/planters.jpg', 34.99, 'Set of 3 modern ceramic planters with drainage holes', '550e8400-e29b-41d4-a716-446655440004', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440010', 'LED String Lights', 'HOME_GARDEN', 'https://example.com/images/lights.jpg', 19.99, 'Warm white LED string lights perfect for indoor and outdoor decoration', '550e8400-e29b-41d4-a716-446655440004', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440011', 'Memory Foam Pillow', 'HOME_GARDEN', 'https://example.com/images/pillow.jpg', 44.99, 'Ergonomic memory foam pillow with cooling gel layer', '550e8400-e29b-41d4-a716-446655440004', 'SEED', 'SEED'),
    
    -- Sports & Outdoors
    ('650e8400-e29b-41d4-a716-446655440012', 'Yoga Mat Premium', 'SPORTS_OUTDOORS', 'https://example.com/images/yogamat.jpg', 29.99, 'Non-slip eco-friendly yoga mat with carrying strap', '550e8400-e29b-41d4-a716-446655440005', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440013', 'Camping Backpack 50L', 'SPORTS_OUTDOORS', 'https://example.com/images/backpack.jpg', 89.99, 'Durable waterproof camping backpack with multiple compartments', '550e8400-e29b-41d4-a716-446655440005', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440014', 'Resistance Bands Set', 'SPORTS_OUTDOORS', 'https://example.com/images/bands.jpg', 24.99, 'Set of 5 resistance bands with different strength levels', '550e8400-e29b-41d4-a716-446655440005', 'SEED', 'SEED'),
    
    -- Books & Media
    ('650e8400-e29b-41d4-a716-446655440015', 'Bestseller Novel Collection', 'BOOKS_MEDIA', 'https://example.com/images/books.jpg', 39.99, 'Collection of 3 contemporary bestselling novels', '550e8400-e29b-41d4-a716-446655440006', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440016', 'Art Supplies Kit', 'BOOKS_MEDIA', 'https://example.com/images/art.jpg', 54.99, 'Complete art supplies kit for beginners and professionals', '550e8400-e29b-41d4-a716-446655440006', 'SEED', 'SEED'),
    
    -- Food & Beverage
    ('650e8400-e29b-41d4-a716-446655440017', 'Organic Coffee Beans 1kg', 'FOOD_BEVERAGE', 'https://example.com/images/coffee.jpg', 24.99, 'Premium organic arabica coffee beans, medium roast', '550e8400-e29b-41d4-a716-446655440007', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440018', 'Artisan Chocolate Gift Box', 'FOOD_BEVERAGE', 'https://example.com/images/chocolate.jpg', 34.99, 'Handcrafted gourmet chocolate assortment in elegant gift box', '550e8400-e29b-41d4-a716-446655440007', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440019', 'Green Tea Collection', 'FOOD_BEVERAGE', 'https://example.com/images/tea.jpg', 19.99, 'Premium loose leaf green tea variety pack', '550e8400-e29b-41d4-a716-446655440007', 'SEED', 'SEED'),
    ('650e8400-e29b-41d4-a716-446655440020', 'Organic Honey 500g', 'FOOD_BEVERAGE', 'https://example.com/images/honey.jpg', 15.99, 'Raw organic wildflower honey from sustainable beekeeping', '550e8400-e29b-41d4-a716-446655440007', 'SEED', 'SEED');
