-- =====================================================
-- 商品マスタ
-- =====================================================
CREATE TABLE product (
  product_id BIGSERIAL PRIMARY KEY,
  product_cd VARCHAR(50) NOT NULL UNIQUE,
  product_name VARCHAR(200) NOT NULL,
  price INT DEFAULT NULL,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL
);

COMMENT ON TABLE product IS '商品マスタ';
COMMENT ON COLUMN product.product_id IS '商品ID';
COMMENT ON COLUMN product.product_cd IS '商品コード';
COMMENT ON COLUMN product.product_name IS '商品名';
COMMENT ON COLUMN product.price IS '単価（円）';
COMMENT ON COLUMN product.cre_prg IS '作成プログラム';
COMMENT ON COLUMN product.cre_time IS '作成日時';
COMMENT ON COLUMN product.upd_prg IS '更新プログラム';
COMMENT ON COLUMN product.upd_time IS '更新日時';
COMMENT ON COLUMN product.remark IS '備考';

-- =====================================================
-- 在庫テーブル
-- =====================================================
CREATE TABLE stock (
  stock_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  stock_qty INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_stock
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

COMMENT ON TABLE stock IS '在庫テーブル';
COMMENT ON COLUMN stock.stock_id IS '在庫ID';
COMMENT ON COLUMN stock.product_id IS '商品ID';
COMMENT ON COLUMN stock.stock_qty IS '在庫数';
COMMENT ON COLUMN stock.cre_prg IS '作成プログラム';
COMMENT ON COLUMN stock.cre_time IS '作成日時';
COMMENT ON COLUMN stock.upd_prg IS '更新プログラム';
COMMENT ON COLUMN stock.upd_time IS '更新日時';
COMMENT ON COLUMN stock.remark IS '備考';

-- =====================================================
-- 入荷テーブル
-- =====================================================
CREATE TABLE receive (
  receive_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_receive
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

COMMENT ON TABLE receive IS '入荷テーブル';
COMMENT ON COLUMN receive.receive_id IS '入荷ID';
COMMENT ON COLUMN receive.product_id IS '商品ID';
COMMENT ON COLUMN receive.quantity IS '入荷数';
COMMENT ON COLUMN receive.cre_prg IS '作成プログラム';
COMMENT ON COLUMN receive.cre_time IS '作成日時';
COMMENT ON COLUMN receive.upd_prg IS '更新プログラム';
COMMENT ON COLUMN receive.upd_time IS '更新日時';
COMMENT ON COLUMN receive.remark IS '備考';

-- =====================================================
-- 出荷テーブル
-- =====================================================
CREATE TABLE ship (
  ship_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_ship
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

COMMENT ON TABLE ship IS '出荷テーブル';
COMMENT ON COLUMN ship.ship_id IS '出荷ID';
COMMENT ON COLUMN ship.product_id IS '商品ID';
COMMENT ON COLUMN ship.quantity IS '出荷数';
COMMENT ON COLUMN ship.cre_prg IS '作成プログラム';
COMMENT ON COLUMN ship.cre_time IS '作成日時';
COMMENT ON COLUMN ship.upd_prg IS '更新プログラム';
COMMENT ON COLUMN ship.upd_time IS '更新日時';
COMMENT ON COLUMN ship.remark IS '備考';
