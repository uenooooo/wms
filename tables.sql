-- 商品マスタ
CREATE TABLE products (
  product_id BIGSERIAL PRIMARY KEY,
  product_cd VARCHAR(50) NOT NULL,
  product_name VARCHAR(200) NOT NULL,
  price INT DEFAULT NULL,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL
);

-- 在庫テーブル
CREATE TABLE stocks (
  stock_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  stock_qty INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_stock FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 入荷テーブル
CREATE TABLE receive (
  receive_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_receive FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- 出荷テーブル
CREATE TABLE ship (
  ship_id BIGSERIAL PRIMARY KEY,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  cre_prg VARCHAR(100) DEFAULT NULL,
  cre_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  upd_prg VARCHAR(100) DEFAULT NULL,
  upd_time TIMESTAMP DEFAULT NULL,
  remark VARCHAR(500) DEFAULT NULL,
  CONSTRAINT fk_product_ship FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- コメント付与
COMMENT ON TABLE products IS '商品マスタ';
COMMENT ON COLUMN products.product_id IS '商品ID';
COMMENT ON COLUMN products.product_cd IS '商品コード';
COMMENT ON COLUMN products.product_name IS '商品名';
COMMENT ON COLUMN products.price IS '単価（円）';
COMMENT ON COLUMN products.cre_prg IS '作成プログラム';
COMMENT ON COLUMN products.cre_time IS '作成日時';
COMMENT ON COLUMN products.upd_prg IS '更新プログラム';
COMMENT ON COLUMN products.upd_time IS '更新日時';
COMMENT ON COLUMN products.remark IS '備考';

COMMENT ON TABLE stocks IS '在庫テーブル';
COMMENT ON COLUMN stocks.stock_id IS '在庫ID';
COMMENT ON COLUMN stocks.product_id IS '商品ID';
COMMENT ON COLUMN stocks.stock_qty IS '在庫数';
COMMENT ON COLUMN stocks.cre_prg IS '作成プログラム';
COMMENT ON COLUMN stocks.cre_time IS '作成日時';
COMMENT ON COLUMN stocks.upd_prg IS '更新プログラム';
COMMENT ON COLUMN stocks.upd_time IS '更新日時';
COMMENT ON COLUMN stocks.remark IS '備考';

COMMENT ON TABLE receive IS '入荷テーブル';
COMMENT ON COLUMN receive.receive_id IS '入荷ID';
COMMENT ON COLUMN receive.product_id IS '商品ID';
COMMENT ON COLUMN receive.quantity IS '入荷数';
COMMENT ON COLUMN receive.cre_prg IS '作成プログラム';
COMMENT ON COLUMN receive.cre_time IS '作成日時';
COMMENT ON COLUMN receive.upd_prg IS '更新プログラム';
COMMENT ON COLUMN receive.upd_time IS '更新日時';
COMMENT ON COLUMN receive.remark IS '備考';

COMMENT ON TABLE ship IS '出荷テーブル';
COMMENT ON COLUMN ship.ship_id IS '出荷ID';
COMMENT ON COLUMN ship.product_id IS '商品ID';
COMMENT ON COLUMN ship.quantity IS '出荷数';
COMMENT ON COLUMN ship.cre_prg IS '作成プログラム';
COMMENT ON COLUMN ship.cre_time IS '作成日時';
COMMENT ON COLUMN ship.upd_prg IS '更新プログラム';
COMMENT ON COLUMN ship.upd_time IS '更新日時';
COMMENT ON COLUMN ship.remark IS '備考';
