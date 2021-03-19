USE [DEMO]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 13/03/2021 9:36:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[password] [varchar](255) NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[username] [varchar](255) NULL,
	[isdelete] [bit] NULL,
	[role] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[brand]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cart]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[total] [float] NULL,
	[update_date] [date] NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[cart_detail]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_price] [float] NULL,
	[quantity] [int] NULL,
	[total] [float] NULL,
	[update_date] [date] NULL,
	[cart_id] [int] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[comment]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](255) NULL,
	[created_date] [date] NULL,
	[rate] [int] NULL,
	[update_date] [date] NULL,
	[isdelete] [bit] NULL,
	[user_id] [int] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[delivery]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[email]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[email](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[email] [varchar](255) NULL,
	[isdelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[invoice]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[invoice](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[created_date] [date] NULL,
	[payment] [nvarchar](255) NULL,
	[status] [int] NULL,
	[total] [float] NULL,
	[update_date] [date] NULL,
	[update_by] [varchar](255) NULL,
	[isdelete] [bit] NULL,
	[user_id] [int] NULL,
	[voucher_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[invoice_detail]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[invoice_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[product_price] [int] NULL,
	[quantity] [int] NULL,
	[total] [float] NULL,
	[update_date] [date] NULL,
	[invoice_id] [int] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[product]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[created_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[description] [nvarchar](255) NULL,
	[issale] [bit] NULL,
	[name] [nvarchar](255) NULL,
	[price] [float] NULL,
	[price_sale] [float] NULL,
	[isdelete] [bit] NULL,

	[gender] [bit] NOT NULL,
	[creatd_by] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_detail]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](max) NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_image]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product_image](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[image] [varchar](255) NULL,
	[proiority] [int] NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[isdelete] [bit] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_property]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product_property](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[name] [nvarchar](255) NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_property_detail]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[product_property_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[description] [nvarchar](255) NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[product_id] [int] NULL,
	[product_property_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[product_type]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[provider]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[provider](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [nvarchar](255) NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[email] [varchar](255) NULL,
	[name] [nvarchar](255) NULL,
	[phone] [varchar](255) NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[isdelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[storage]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[storage](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[quantity] [int] NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[provider_id] [int] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[address] [nvarchar](255) NULL,
	[birthday] [date] NULL,
	[created_date] [date] NULL,
	[email] [varchar](255) NULL,
	[fullname] [nvarchar](255) NULL,
	[gender] [bit] NULL,
	[password] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[update_date] [date] NULL,
	[username] [varchar](255) NULL,
	[isdelete] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[users_token]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users_token](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_status] [int] NULL,
	[email_confirm_token] [varchar](255) NULL,
	[password_reminder_expire] [date] NULL,
	[password_reminder_token] [varchar](255) NULL,
	[registration_time] [date] NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[voucher]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[voucher](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[code] [varchar](255) NULL,
	[create_by] [varchar](255) NULL,
	[created_date] [date] NULL,
	[expiration_date] [date] NULL,
	[limit_use] [int] NULL,
	[status] [bit] NULL,
	[update_by] [varchar](255) NULL,
	[updated_date] [date] NULL,
	[value] [int] NULL,

PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[wishlish]    Script Date: 13/03/2021 9:36:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[wishlish](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [date] NULL,
	[update_date] [date] NULL,
	[user_id] [int] NULL,
	[product_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[admin] ON 

INSERT [dbo].[admin] ([id], [create_by], [created_date], [password], [update_by], [updated_date], [username], [isdelete], [role]) VALUES (1, NULL, CAST(N'2021-03-04' AS Date), N'1234567', NULL, NULL, N'admin@gmail.com', 0, 0)
INSERT [dbo].[admin] ([id], [create_by], [created_date], [password], [update_by], [updated_date], [username], [isdelete], [role]) VALUES (2, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1234567', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'admin1@gmail.com', 0, 0)
INSERT [dbo].[admin] ([id], [create_by], [created_date], [password], [update_by], [updated_date], [username], [isdelete], [role]) VALUES (3, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1234567', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'admin2@gmail.com', 0, 0)
INSERT [dbo].[admin] ([id], [create_by], [created_date], [password], [update_by], [updated_date], [username], [isdelete], [role]) VALUES (4, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1234567', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'admin3@gmail.com', 1, 0)
SET IDENTITY_INSERT [dbo].[admin] OFF

SET IDENTITY_INSERT [dbo].[cart] ON 

INSERT [dbo].[cart] ([id], [created_date], [total], [update_date], [user_id]) VALUES (1, CAST(N'2021-03-04' AS Date), 10000000, CAST(N'2021-03-04' AS Date), 1)
INSERT [dbo].[cart] ([id], [created_date], [total], [update_date], [user_id]) VALUES (2, CAST(N'2021-03-04' AS Date), 13849000, CAST(N'2021-03-04' AS Date), 2)
INSERT [dbo].[cart] ([id], [created_date], [total], [update_date], [user_id]) VALUES (3, CAST(N'2021-03-04' AS Date), 9990000, CAST(N'2021-03-04' AS Date), 3)
INSERT [dbo].[cart] ([id], [created_date], [total], [update_date], [user_id]) VALUES (4, CAST(N'2021-03-04' AS Date), 9700000, CAST(N'2021-03-04' AS Date), 4)
SET IDENTITY_INSERT [dbo].[cart] OFF
SET IDENTITY_INSERT [dbo].[cart_detail] ON 

INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (1, 1000000, 1, 1000000, CAST(N'2021-03-04' AS Date), 1, 1)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (2, 990000, 1, 990000, CAST(N'2021-03-04' AS Date), 1, 2)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (3, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 1, 3)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (4, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 2, 2)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (5, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 2, 3)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (6, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 2, 4)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (7, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 3, 5)
INSERT [dbo].[cart_detail] ([id], [product_price], [quantity], [total], [update_date], [cart_id], [product_id]) VALUES (8, 1310000, 1, 1310000, CAST(N'2021-03-04' AS Date), 4, 6)
SET IDENTITY_INSERT [dbo].[cart_detail] OFF
SET IDENTITY_INSERT [dbo].[comment] ON 

INSERT [dbo].[comment] ([id], [content], [created_date], [rate], [update_date], [isdelete], [user_id], [product_id]) VALUES (1, N'Sản Phẩm tốt', CAST(N'2021-03-04' AS Date), 5, CAST(N'2021-03-04' AS Date), 0, 1, 1)
INSERT [dbo].[comment] ([id], [content], [created_date], [rate], [update_date], [isdelete], [user_id], [product_id]) VALUES (2, N'Bình Thường', CAST(N'2021-03-04' AS Date), 2, CAST(N'2021-03-04' AS Date), 0, 1, 2)
INSERT [dbo].[comment] ([id], [content], [created_date], [rate], [update_date], [isdelete], [user_id], [product_id]) VALUES (3, N'Sản Phẩm Kém chất lượng', CAST(N'2021-03-04' AS Date), 1, CAST(N'2021-03-04' AS Date), 0, 2, 2)
SET IDENTITY_INSERT [dbo].[comment] OFF

SET IDENTITY_INSERT [dbo].[email] ON 

INSERT [dbo].[email] ([id], [created_date], [email], [isdelete]) VALUES (1, CAST(N'2021-03-04' AS Date), N'tranvanlong@gmail.com', 0)
INSERT [dbo].[email] ([id], [created_date], [email], [isdelete]) VALUES (2, CAST(N'2021-03-04' AS Date), N'levanluyen@gmail.com', 0)
INSERT [dbo].[email] ([id], [created_date], [email], [isdelete]) VALUES (3, CAST(N'2021-03-04' AS Date), N'nguyentrongnhan@gmail.com', 0)
INSERT [dbo].[email] ([id], [created_date], [email], [isdelete]) VALUES (4, CAST(N'2021-03-04' AS Date), N'tranvansinh@gmail.com', 0)
SET IDENTITY_INSERT [dbo].[email] OFF
SET IDENTITY_INSERT [dbo].[invoice] ON 

INSERT [dbo].[invoice] ([id], [code], [created_date], [payment], [status], [total], [update_date], [update_by], [isdelete], [user_id], [voucher_id]) VALUES (1, N'HD01', CAST(N'2021-03-04' AS Date), N'Trực Tiếp', 4, 10000000, CAST(N'2021-03-04' AS Date), N'admin@gmail.com', 0, 1, 1)
INSERT [dbo].[invoice] ([id], [code], [created_date], [payment], [status], [total], [update_date], [update_by], [isdelete], [user_id], [voucher_id]) VALUES (2, N'HD01', CAST(N'2021-03-04' AS Date), N'Thẻ', 3, 9000000, CAST(N'2021-03-04' AS Date), N'admin@gmail.com', 0, 1, NULL)
INSERT [dbo].[invoice] ([id], [code], [created_date], [payment], [status], [total], [update_date], [update_by], [isdelete], [user_id], [voucher_id]) VALUES (3, N'HD01', CAST(N'2021-03-04' AS Date), N'Thẻ', 1, 9000000, CAST(N'2021-03-04' AS Date), N'admin@gmail.com', 0, 2, 1)
INSERT [dbo].[invoice] ([id], [code], [created_date], [payment], [status], [total], [update_date], [update_by], [isdelete], [user_id], [voucher_id]) VALUES (4, N'HD01', CAST(N'2021-03-04' AS Date), N'Trực Tiếp', 2, 9000000, CAST(N'2021-03-04' AS Date), N'admin@gmail.com', 0, 2, NULL)
SET IDENTITY_INSERT [dbo].[invoice] OFF
SET IDENTITY_INSERT [dbo].[invoice_detail] ON 

INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (1, CAST(N'2021-03-04' AS Date), 1000000, 1, 1000000, CAST(N'2021-03-04' AS Date), 1, 1)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (2, CAST(N'2021-03-04' AS Date), 9000000, 2, 1800000, CAST(N'2021-03-04' AS Date), 1, 2)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (3, CAST(N'2021-03-04' AS Date), 1000000, 1, 1000000, CAST(N'2021-03-04' AS Date), 2, 3)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (4, CAST(N'2021-03-04' AS Date), 9000000, 2, 1800000, CAST(N'2021-03-04' AS Date), 2, 2)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (5, CAST(N'2021-03-04' AS Date), 1000000, 1, 1000000, CAST(N'2021-03-04' AS Date), 3, 3)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (6, CAST(N'2021-03-04' AS Date), 9000000, 2, 1800000, CAST(N'2021-03-04' AS Date), 3, 4)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (7, CAST(N'2021-03-04' AS Date), 1000000, 1, 1000000, CAST(N'2021-03-04' AS Date), 4, 3)
INSERT [dbo].[invoice_detail] ([id], [created_date], [product_price], [quantity], [total], [update_date], [invoice_id], [product_id]) VALUES (8, CAST(N'2021-03-04' AS Date), 23000000, 2, 3400000, CAST(N'2021-03-04' AS Date), 4, 5)
SET IDENTITY_INSERT [dbo].[invoice_detail] OFF
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (1, N'EFR-527L-1AVUDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Đồng hồ Casio EFR-527L-1AVUDF dành cho nam giới, thuộc bộ sưu tập Edifice của Casio với tính năng Chronograph giờ thể thao 6 kim chỉ cá tính, dây đeo bằng da đen nam tính và còn có 1 lịch ngày.', 0, N'CASIO EFR-527L-1AVUDF', 3196000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],[gender], [creatd_by]) VALUES (2, N'EFR-547D-2AVUDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Đồng hồ Casio EFR-547D-2AVUDF với mặt số lớn phong cách thể thao mạnh mẽ, nền xanh sang trọng cùng kim chỉ và vạch số được phủ phản quang nổi bật, đèn LED có độ chiếu sáng cao giúp nhìn rõ trong đêm.', 0, N'CASIO EFR-547D-2AVUDF', 4230000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (3, N'MTP-1302L-1AVDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Đồng hồ Casio MTP-1302L-1AVDF có vỏ kim loại được mạ bạc tinh tế quanh nền đen mặt số, kim chỉ và vạch số được phủ phản quang nổi bật, dây đeo da vân đen lịch lãm, nam tính.', 1, N'CASIO EFR-547D-2AVUDF', 1128000, 1000000, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (4, N'EFB-302JD-1ADR', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Đồng hồ nam Casio EFB-302JD-1ADR có kiểu dáng với phong cách thể thao, vỏ máy cùng với dây đeo bằng thép không gỉ tạo vẻ chắc chắn, 3 ô phụ với 3 chức năng khác nhau tạo nên vẻ hiện đại.', 0, N'CASIO EFR-547D-2AVUDF', 10264000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (5, N'MTP-V006L-1B2UDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio MTP-V006L-1B2UDF phiên bản dây da trẻ trung cho phái mạnh với kiểu da trơn cùng với nền mặt số size 38mm hiện thị chức năng đơn giản 3 kim.', 0, N'CASIO MTP-V006L-1B2UDF', 776000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (6, N'A168WG-9WDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Đồng hồ Casio A168WG-9WDF với hình dáng truyền thống của hãng, phù hợp cho cả nam lẫn nữ, tông màu vàng chủ đạo từng chi tiết vỏ, mặt số và dây đeo tạo nên thời trang sang trọng, quý phái và thanh lịch.', 0, N'CASIO A168WG-9WDF', 1598000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (7, N'MTP-1335D-2A2VDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio MTP-1335D-2A2VDF mặt số xanh size 41mm tone màu thời trang cùng với thiết kế đơn giản chức năng 3 kim.', 0, N'CASIO MTP-1335D-2A2VDF', 1363000, 0, 0, 1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (8, N'MTP-1170A-2ARDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Trẻ trung nam tính với mẫu Casio MTP-1170A-2ARDF ẩn mình với vẻ ngoài giản dị của chiếc đồng hồ 3 kim thời trang với nền mặt số được phủ tông màu xanh nổi bật.', 0, N'CASIO MTP-1170G-7ARDF', 1246000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (9, N'MTP-1170G-7ARDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Trẻ trung nam tính với mẫu Casio MTP-1170A-2ARDF ẩn mình với vẻ ngoài giản dị của chiếc đồng hồ 3 kim thời trang với nền mặt số được phủ tông màu xanh nổi bật.', 1, N'CASIO MTP-1170A-2ARDF', 1034000, 999000, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (10, N'MRW-200HD-1BVDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio MRW-200HD-1BVDF phiên bản thể thao với khả năng chống nước vượt trội 10ATM, nền cọc số học trò tạo hình dày dặn tone màu trắng nổi bật trên mặt số size 44mm.', 0, N'CASIO MRW-200HD-1BVDF', 1246000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (11, N'MRW-200HD-7BVDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio MRW-200HD-7BVDF mặt số trắng size lớn 44mm nối bật với thiết kế viền Bezel cọc số dày dặn nam tính dễ quan sát cùng khả năng chịu nước lên đến 10atm.', 0, N'CASIO MRW-200HD-7BVDF', 1246000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (12, N'AW-90H-9EVDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio AW-90H-9EVDF phiên bản dây vỏ nhựa chịu va đập phối tone đen năng động, mặt số đen size 38mm chức năng kim chỉ phối cùng ô số điện tử tính năng Dual time.', 0, N'CASIO AW-90H-9EVDF', 870000, 0, 0,  1, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (13, N'LTP-V005D-4B2UDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio LTP-V005D-4B2UDF thiết kế đơn giản trẻ trung 3 kim trên nền mặt số size 28mm được phối tone màu hồng, cùng với chi tiết các cọc vạch số tạo nét thanh mảnh nữ tính.', 1, N'CASIO LTP-V005D-4B2UDF', 729000, 620000, 0,  0, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (14, N'SHE-4055PGL-7BUDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio SHE-4055PGL-7BUDF phiên bản đính pha lê tương ứng với các múi giờ trên mặt số trắng size 30mm tạo nên vẻ đẹp sang trọng trẻ trung khi kết hợp cùng vỏ máy vàng hồng.', 0, N'CASIO SHE-4055PGL-7BUDF', 4113000, 0, 0,  0, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete], [gender], [creatd_by]) VALUES (15, N'SHE-4533D-7AUDF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio SHE-4533D-7AUDF thời trang sang trọng với thiết kế đính pha lê tại vị trí 9 giờ tạo nên điểm nhấn nổi bật trên mặt số size 30mm.', 0, N'CASIO SHE-4533D-7AUDF', 3220000, 0, 0,  0, NULL)
INSERT [dbo].[product] ([id], [code], [created_by], [created_date], [description], [issale], [name], [price], [price_sale], [isdelete],  [gender], [creatd_by]) VALUES (16, N'LTP-E157MR-9ADF', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Mẫu Casio LTP-E157MR-9ADF dây đeo kim loại mạ vàng hồng phiên bản dây lưới thời trang kết hợp cùng lối thiết kế đơn giản chức năng 3 kim.', 0, N'CASIO LTP-E157MR-9ADF', 2867000, 0, 0,  0, NULL)
SET IDENTITY_INSERT [dbo].[product] OFF
SET IDENTITY_INSERT [dbo].[product_detail] ON 

INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (1, N'Nằm trong bộ sưu tập Casio Edifice WR100m ăn khách nhất hiện nay, đồng hồ Casio EFR-527L-1AVUDF còn sở hữu giá thành cực rẻ chưa đến 4 triệu đồng. Vậy thiết kế lần này có gì mà tạo nên được sức hút mạnh mẽ dành cho nam giới đến vậy? Hãy cùng Hải Triều tìm hiểu chi tiết ngay bên dưới.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 1)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (2, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 2)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (3, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 3)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (4, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 4)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (5, N'Đối với các cặp đôi, việc lựa chọn những sản phẩm mang màu sắc trung tính, vừa phù hợp với phái mạnh lại có thể dễ dàng phù hợp với cổ tay của phái đẹp là điều không hề dễ dàng. Thế nhưng, với phiên bản đồng hồ Casio A168WG-9WDF đến từ thương hiệu đồng hồ Casio này, bạn hoàn toàn có thể an tâm và tin tưởng hãng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 5)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (6, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 6)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (7, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 7)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (8, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 8)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (9, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 9)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (10, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (11, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 11)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (12, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 12)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (13, N'Casio hiện đang đứng trong top những thương hiệu đồng hồ bán chạy nhất Nhật Bản. Ở thị trường Việt Nam, có thể nói, hãng này dường như đã trở nên quá đỗi quen thuộc và chiếm được rất nhiều cảm tình của người tiêu dùng.

Thành lập vào năm 1946 bởi kỹ sư chế tạo chuyên nghiệp Tadao Kashio, một công ty sản xuất và kinh doanh linh kiện điện tử chính là tiền thân của thương hiệu.

Nhờ có nền tảng vững chắc mà Casio khá thuận lợi trên con đường đến với những chiếc đồng hồ đeo tay. Tuy nhiên, không vì thế mà hãng chủ quan, đó là lý do 28 năm sau khi thành lập mới có phiên bản Casiotron.

Đồng hồ Casio luôn phát triển theo cách rất riêng, thể hiện rõ nhất trong những sản phẩm chứa đầy sự bức phá công nghệ, đem đến trải nghiệm vừa hiện đại vừa tiện lợi cho người dùng.

Trong khi thế giới đang đi theo chiều hướng mỏng hóa thì năm 1983, Casio cho ra mắt dòng G-Shock, sau đó là Baby-G. Nằm ngoài dự đoán, những thiết kế hầm hố này vậy mà lại nhận về không ít tiếng thơm, đến nay vẫn còn rất nổi tiếng trong giới trẻ.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 13)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (14, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 14)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (15, N'Nếu bạn là một cô gái ưa đeo đồng hồ, chắc chắn bạn đã từng tìm hiểu qua dòng Sheen của thương hiệu đồng hồ Casio danh tiếng. Một trong những mẫu đắt khách của nó không thể bỏ qua phiên bản đồng hồ Casio SHE-4533D-7AUDF, cỗ máy mang vẻ đẹp thanh lịch nhưng cũng rất kiêu sa.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 15)
INSERT [dbo].[product_detail] ([id], [content], [create_by], [created_date], [update_by], [updated_date], [product_id]) VALUES (16, N'Khi nhắc tới thương hiệu đồng hồ Casio thì người ta sẽ nghĩ ngay đến sự sáng tạo được đưa vào trong những mẫu thiết kế, từ những sản phẩm có mức giá rẻ nhất cho đến các phiên bản đồng hồ cao cấp hơn hãng không bao giờ làm cho chúng ta thất vọng.', N'admin@gmaail.com', CAST(N'2021-03-04' AS Date), N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 16)
SET IDENTITY_INSERT [dbo].[product_detail] OFF
SET IDENTITY_INSERT [dbo].[product_image] ON 

INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1_anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 1)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (2, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1_anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 1)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (3, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1_anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 1)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (4, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1_anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 1)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (5, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'1_anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 1)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (6, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'2_anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 2)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (7, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'2_anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 2)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (8, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'2_anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 2)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (9, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'2_anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 2)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'2_anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 2)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (11, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'3_anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 3)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (12, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'3_anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 3)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (13, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'3_anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 3)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (14, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'3_anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 3)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (15, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'3_anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 3)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (16, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'4_anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 4)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (17, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'4_anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 4)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (18, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'4_anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 4)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (19, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'4_anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 4)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (20, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'4_anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 4)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (21, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'5_anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 5)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (22, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'5_anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 5)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (23, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'5_anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 5)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (24, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'5_anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 5)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (25, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'5_anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 5)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (26, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 6)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (27, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 6)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (28, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 6)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (29, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 6)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (30, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 6)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (31, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 7)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (32, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 7)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (33, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 7)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (34, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 7)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (35, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 7)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (36, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 8)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (37, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 8)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (38, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 8)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (39, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 8)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (40, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 8)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (41, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 9)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (42, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 9)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (43, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 9)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (44, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 9)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (45, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 9)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (46, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 10)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (47, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 10)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (48, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 10)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (49, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 10)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (50, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 10)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (51, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 11)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (52, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 11)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (53, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 11)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (54, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 11)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (55, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 11)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (56, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 12)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (57, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 12)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (58, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 12)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (59, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 12)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (60, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 12)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (61, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 13)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (62, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 13)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (63, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 13)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (64, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 13)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (65, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 13)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (66, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 14)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (67, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 14)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (68, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 14)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (69, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 14)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (70, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 14)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (71, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 15)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (72, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 15)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (73, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 15)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (74, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 15)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (75, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 15)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (76, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh1.jpg', 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 16)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (77, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh2.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 16)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (78, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh3.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 16)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (79, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh4.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 16)
INSERT [dbo].[product_image] ([id], [create_by], [created_date], [image], [proiority], [update_by], [updated_date], [isdelete], [product_id]) VALUES (80, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'anh5.jpg', 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0, 16)
SET IDENTITY_INSERT [dbo].[product_image] OFF
SET IDENTITY_INSERT [dbo].[product_property] ON 

INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Số Hiệu Sản Phẩm', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (2, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Xuất Xứ', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (3, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Kính', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (4, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Máy', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (5, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Bảo Hành', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (6, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Ðường Kính Mặt Số', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (7, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Bề Dày Mặt Số', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (8, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Niềng', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (9, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Dây Deo', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Màu Mặt Số', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (11, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Chống Nước', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[product_property] ([id], [create_by], [created_date], [name], [update_by], [updated_date]) VALUES (12, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), N'Chức Năng', N'admin@gmail.com', CAST(N'2021-03-04' AS Date))
SET IDENTITY_INSERT [dbo].[product_property] OFF
SET IDENTITY_INSERT [dbo].[product_property_detail] ON 

INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (1, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'EFR-527L-1AVUDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (2, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (3, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (4, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (5, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (6, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'41mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (7, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'11.6 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (8, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (9, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (10, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (11, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'10 ATP', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (12, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Chronograph', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 1, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (13, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'EFR-547D-2AVUDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (14, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (15, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (16, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (17, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (18, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'47.2mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (19, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'13.9 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (20, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (21, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (22, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Xanh', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (23, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'10 ATP', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (24, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Chronograph', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 2, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (25, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MTP-1302L-1AVDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (26, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (27, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (28, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (29, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (30, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'38 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (31, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'9.2 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (32, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (33, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãn', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (34, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (35, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'5 ATP', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (36, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 3, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (37, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'EFB-302JD-1ADR', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (38, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (39, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Sapphire (Kính Chống Trầy)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (40, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (41, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (42, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'43 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (43, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'11.7 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (44, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (45, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (46, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (47, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'10 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (48, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Giờ Báo Thức – Giờ Thế Giới', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 4, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (49, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MTP-V006L-1B2UDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (50, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (51, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (52, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (53, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (54, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'38 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (55, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'9.4 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (56, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (57, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (58, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (59, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (60, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Lịch Thứ', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 5, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (61, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'A168WG-9WDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (62, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (63, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Resin Glass (Kính Nhựa)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (64, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (65, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (66, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'38.6mm x 36.3mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (67, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'9.6 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (68, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (69, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (70, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Vàng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (71, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (72, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch – Bộ Bấm Giờ – Vài Chức Năng Khác', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 6, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (73, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MTP-1335D-2A2VDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (74, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (75, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (76, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (77, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (78, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'41.5 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (79, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'12.4 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (80, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (81, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (82, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Xanh', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (83, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'5 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (84, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Lịch Thứ', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 7, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (85, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MTP-1170A-2ARDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (86, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (87, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (88, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (89, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (90, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'36mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (91, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'8 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (92, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (93, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (94, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Xanh', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (95, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (96, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 8, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (97, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MTP-1170G-7ARDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (98, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (99, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 3)
GO
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (100, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (101, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (102, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'35mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (103, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'8 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (104, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (105, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (106, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Trắng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (107, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (108, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 9, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (109, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MRW-200HD-1BVDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (110, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (111, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Resin Glass (Kính Nhựa)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (112, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (113, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (114, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'44.6mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (115, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'11.6 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (116, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (117, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (118, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (119, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'10 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (120, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Lịch Thứ', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (121, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'MRW-200HD-7BVDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (122, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (123, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Resin Glass (Kính Nhựa)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (124, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (125, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (126, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'43.2mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (127, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'11.6 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (128, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (129, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (130, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Trắng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (131, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'10 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (132, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Lịch Thứ', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 10, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (133, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'AW-90H-9EVDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (134, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (135, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Resin Glass (Kính Nhựa)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (136, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (137, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (138, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'38.6 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (139, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'9.5 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (140, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (141, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (142, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Đen', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (143, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'5 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (144, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày – Lịch Thứ', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 11, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (145, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'LTP-V005D-4B2UDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (146, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (147, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (148, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (149, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (150, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'28.2 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (151, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'7.5 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (152, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (153, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Cao Su', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (154, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Hồng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (155, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (156, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 12, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (157, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'SHE-4055PGL-7BUDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (158, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (159, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (160, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (161, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (162, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'admin@gmail.com', N'30 mm', CAST(N'2021-03-05' AS Date), 13, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (163, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'7 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (164, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (165, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (166, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Trắng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (167, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'5 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (168, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 13, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (169, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'SHE-4533D-7AUDF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (170, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (171, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Sapphire (Kính Chống Trầy)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (172, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (173, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (174, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'admin@gmail.com', N'30 mm', CAST(N'2021-03-05' AS Date), 14, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (175, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'5.8 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (176, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (177, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (178, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Trắng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (179, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (180, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Lịch Ngày', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 14, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (181, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'LTP-E157MR-9ADF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (182, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (183, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (184, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (185, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (186, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'32.5 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (187, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'8 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 7)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (188, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (189, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (190, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Vàng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (191, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (192, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 15, 12)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (193, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'LTP-E157MR-9ADF', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 1)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (194, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Nhật Bản', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 2)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (195, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Mineral Crystal (Kính Cứng)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 3)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (196, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Quartz (Pin)', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 4)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (197, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'1 Năm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 5)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (198, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'32mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 6)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (199, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'8 mm', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 7)
GO
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (200, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 8)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (201, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Dây Da Chính Hãng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 9)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (202, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'Vàng', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 10)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (203, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'3 ATM', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 11)
INSERT [dbo].[product_property_detail] ([id], [create_by], [created_date], [description], [update_by], [updated_date], [product_id], [product_property_id]) VALUES (204, N'admin@gmail.com', CAST(N'2021-03-05' AS Date), N'', N'admin@gmail.com', CAST(N'2021-03-05' AS Date), 16, 12)
SET IDENTITY_INSERT [dbo].[product_property_detail] OFF
SET IDENTITY_INSERT [dbo].[provider] ON 

INSERT [dbo].[provider] ([id], [address], [create_by], [created_date], [email], [name], [phone], [update_by], [updated_date], [isdelete]) VALUES (1, N'193/2 Nam Kì Khởi Nghĩa, Phường 7, Quận 3, Tp Hồ Chí Minh', N'admin1@gmil.com', CAST(N'2021-03-04' AS Date), N'donghomanhthang@gmail.com', N'Đồng Hồ Mạnh Thắng', N'0902530204', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0)
INSERT [dbo].[provider] ([id], [address], [create_by], [created_date], [email], [name], [phone], [update_by], [updated_date], [isdelete]) VALUES (2, N'25 Nguyễn Hậu, Phường Tân Thành, Quận Tân Phú, Tp Hồ Chí Minh', N'admin1@gmil.com', CAST(N'2021-03-04' AS Date), N'luxuryfashion@gmail.com', N'Đồ Hồ Luxury Fashion', N'0908616676', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0)
INSERT [dbo].[provider] ([id], [address], [create_by], [created_date], [email], [name], [phone], [update_by], [updated_date], [isdelete]) VALUES (3, N'35A Lê Quang Sung, Phường 2, Quận 6, Tp Hồ Chí Minh', N'admin1@gmil.com', CAST(N'2021-03-04' AS Date), N'many@gmail.com', N'Đồng Hồ Mãn Ý', N'0903945318', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0)
INSERT [dbo].[provider] ([id], [address], [create_by], [created_date], [email], [name], [phone], [update_by], [updated_date], [isdelete]) VALUES (4, N'65 Phan Văn Năm, Phường Phú Thạnh, Quận Tân Phú, Tp Hồ Chí Minh', N'admin1@gmil.com', CAST(N'2021-03-04' AS Date), N'iriswatch@gmail.com', N'Iris Watch', N'0948789787', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0)
INSERT [dbo].[provider] ([id], [address], [create_by], [created_date], [email], [name], [phone], [update_by], [updated_date], [isdelete]) VALUES (5, N'Quầy 69A1 Chợ Đồng Xuân, Quận Hoàn Kiếm, Tp Hà Nội', N'admin1@gmil.com', CAST(N'2021-03-04' AS Date), N'lumino888@gmail.com', N'Lumino 888', N'0967816888', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 0)
SET IDENTITY_INSERT [dbo].[provider] OFF
SET IDENTITY_INSERT [dbo].[storage] ON 

INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 1, 1)
INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (2, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 1, 2)
INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (3, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 2, 3)
INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (4, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 2, 4)
INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (5, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 2, 5)
INSERT [dbo].[storage] ([id], [create_by], [created_date], [quantity], [update_by], [updated_date], [provider_id], [product_id]) VALUES (6, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 10, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 2, 6)
SET IDENTITY_INSERT [dbo].[storage] OFF
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [address], [birthday], [created_date], [email], [fullname], [gender], [password], [phone], [update_date], [username], [isdelete]) VALUES (1, N'195 Nam Kì Khởi Nghĩa, Phường 7, Quận 3', CAST(N'1998-02-21' AS Date), CAST(N'2021-03-04' AS Date), N'user@gmail.com', N'Nguyễn Văn Long', 1, N'123456789', N'0927375838', CAST(N'2021-03-04' AS Date), N'user@gmail.com', 0)
INSERT [dbo].[users] ([id], [address], [birthday], [created_date], [email], [fullname], [gender], [password], [phone], [update_date], [username], [isdelete]) VALUES (2, N'123 Lý Chính Thắng, Phường 7, Quận 3', CAST(N'1998-02-21' AS Date), CAST(N'2021-03-04' AS Date), N'user1@gmail.com', N'Nguyễn Lê Minh', 1, N'123456789', N'0948292830', CAST(N'2021-03-04' AS Date), N'user1@gmail.com', 0)
INSERT [dbo].[users] ([id], [address], [birthday], [created_date], [email], [fullname], [gender], [password], [phone], [update_date], [username], [isdelete]) VALUES (3, N'982 Quang Trung, Phường 6 , Quận Go Vấp', CAST(N'1998-02-21' AS Date), CAST(N'2021-03-04' AS Date), N'user2@gmail.com', N'Nguyễn Thị Lan', 0, N'123456789', N'0935246745', CAST(N'2021-03-04' AS Date), N'user2@gmail.com', 0)
INSERT [dbo].[users] ([id], [address], [birthday], [created_date], [email], [fullname], [gender], [password], [phone], [update_date], [username], [isdelete]) VALUES (4, N'91 Phan Văn Trị, Phường 12 , Quận Gò Vấp', CAST(N'1998-02-21' AS Date), CAST(N'2021-03-04' AS Date), N'user3@gmail.com', N'Lê Hữu Nghĩa', 1, N'123456789', N'0967456423', CAST(N'2021-03-04' AS Date), N'user3@gmail.com', 1)
SET IDENTITY_INSERT [dbo].[users] OFF
SET IDENTITY_INSERT [dbo].[voucher] ON 

INSERT [dbo].[voucher] ([id], [code], [create_by], [created_date], [expiration_date], [limit_use], [status], [update_by], [updated_date], [value]) VALUES (1, N'Voucher1', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), CAST(N'2021-03-11' AS Date), 1, 1, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 100000)
INSERT [dbo].[voucher] ([id], [code], [create_by], [created_date], [expiration_date], [limit_use], [status], [update_by], [updated_date], [value]) VALUES (2, N'Voucher1', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), CAST(N'2021-03-11' AS Date), 4, 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 100000)
INSERT [dbo].[voucher] ([id], [code], [create_by], [created_date], [expiration_date], [limit_use], [status], [update_by], [updated_date], [value]) VALUES (3, N'Voucher1', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), CAST(N'2021-03-11' AS Date), 1, 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 90000)
INSERT [dbo].[voucher] ([id], [code], [create_by], [created_date], [expiration_date], [limit_use], [status], [update_by], [updated_date], [value]) VALUES (4, N'Voucher1', N'admin@gmail.com', CAST(N'2021-03-04' AS Date), CAST(N'2021-03-11' AS Date), 1, 0, N'admin@gmail.com', CAST(N'2021-03-04' AS Date), 90000)
SET IDENTITY_INSERT [dbo].[voucher] OFF
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FKg5uhi8vpsuy0lgloxk2h4w5o6] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FKg5uhi8vpsuy0lgloxk2h4w5o6]
GO
ALTER TABLE [dbo].[cart_detail]  WITH CHECK ADD  CONSTRAINT [FK37hai783jhfcqo6h0pkiqmc9s] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[cart_detail] CHECK CONSTRAINT [FK37hai783jhfcqo6h0pkiqmc9s]
GO
ALTER TABLE [dbo].[cart_detail]  WITH CHECK ADD  CONSTRAINT [FKrg4yopd2252nwj8bfcgq5f4jp] FOREIGN KEY([cart_id])
REFERENCES [dbo].[cart] ([id])
GO
ALTER TABLE [dbo].[cart_detail] CHECK CONSTRAINT [FKrg4yopd2252nwj8bfcgq5f4jp]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FKm1rmnfcvq5mk26li4lit88pc5] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FKm1rmnfcvq5mk26li4lit88pc5]
GO
ALTER TABLE [dbo].[comment]  WITH CHECK ADD  CONSTRAINT [FKqm52p1v3o13hy268he0wcngr5] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[comment] CHECK CONSTRAINT [FKqm52p1v3o13hy268he0wcngr5]
GO

ALTER TABLE [dbo].[invoice]  WITH CHECK ADD  CONSTRAINT [FKc8jotskr93810vgn75qlbusw2] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[invoice] CHECK CONSTRAINT [FKc8jotskr93810vgn75qlbusw2]
GO
ALTER TABLE [dbo].[invoice]  WITH CHECK ADD  CONSTRAINT [FKh8mc37lrohbk7stgatwwn5doq] FOREIGN KEY([voucher_id])
REFERENCES [dbo].[voucher] ([id])
GO
ALTER TABLE [dbo].[invoice] CHECK CONSTRAINT [FKh8mc37lrohbk7stgatwwn5doq]
GO
ALTER TABLE [dbo].[invoice_detail]  WITH CHECK ADD  CONSTRAINT [FKbe6c21nke5fy4m3vw00f23qsf] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[invoice_detail] CHECK CONSTRAINT [FKbe6c21nke5fy4m3vw00f23qsf]
GO
ALTER TABLE [dbo].[invoice_detail]  WITH CHECK ADD  CONSTRAINT [FKit1rbx4thcr6gx6bm3gxub3y4] FOREIGN KEY([invoice_id])
REFERENCES [dbo].[invoice] ([id])
GO
ALTER TABLE [dbo].[invoice_detail] CHECK CONSTRAINT [FKit1rbx4thcr6gx6bm3gxub3y4]
GO

ALTER TABLE [dbo].[product_detail]  WITH CHECK ADD  CONSTRAINT [FKilxoi77ctyin6jn9robktb16c] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[product_detail] CHECK CONSTRAINT [FKilxoi77ctyin6jn9robktb16c]
GO
ALTER TABLE [dbo].[product_image]  WITH CHECK ADD  CONSTRAINT [FK6oo0cvcdtb6qmwsga468uuukk] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[product_image] CHECK CONSTRAINT [FK6oo0cvcdtb6qmwsga468uuukk]
GO
ALTER TABLE [dbo].[product_property_detail]  WITH CHECK ADD  CONSTRAINT [FKc4r6lphnfmjs4dw1wphpn8jin] FOREIGN KEY([product_property_id])
REFERENCES [dbo].[product_property] ([id])
GO
ALTER TABLE [dbo].[product_property_detail] CHECK CONSTRAINT [FKc4r6lphnfmjs4dw1wphpn8jin]
GO
ALTER TABLE [dbo].[product_property_detail]  WITH CHECK ADD  CONSTRAINT [FKlw7vvi10bulb8a3ikt43l4xcn] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[product_property_detail] CHECK CONSTRAINT [FKlw7vvi10bulb8a3ikt43l4xcn]
GO
ALTER TABLE [dbo].[storage]  WITH CHECK ADD  CONSTRAINT [FK39oh80j6vy5odd8cka80mmxsa] FOREIGN KEY([provider_id])
REFERENCES [dbo].[provider] ([id])
GO
ALTER TABLE [dbo].[storage] CHECK CONSTRAINT [FK39oh80j6vy5odd8cka80mmxsa]
GO
ALTER TABLE [dbo].[storage]  WITH CHECK ADD  CONSTRAINT [FKpomua9n0dfb2v8h2wv063epie] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[storage] CHECK CONSTRAINT [FKpomua9n0dfb2v8h2wv063epie]
GO
ALTER TABLE [dbo].[users_token]  WITH CHECK ADD  CONSTRAINT [FKesvxqrjrdcbe03rx712bwki3y] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[users_token] CHECK CONSTRAINT [FKesvxqrjrdcbe03rx712bwki3y]
GO
ALTER TABLE [dbo].[wishlish]  WITH CHECK ADD  CONSTRAINT [FK9ajyr2io55dgq4p6gvxxlajkh] FOREIGN KEY([user_id])
REFERENCES [dbo].[cart] ([id])
GO
ALTER TABLE [dbo].[wishlish] CHECK CONSTRAINT [FK9ajyr2io55dgq4p6gvxxlajkh]
GO
ALTER TABLE [dbo].[wishlish]  WITH CHECK ADD  CONSTRAINT [FKk5gyq5srkehwym63xveyjvsnh] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[wishlish] CHECK CONSTRAINT [FKk5gyq5srkehwym63xveyjvsnh]
GO
ALTER TABLE [dbo].[wishlish]  WITH CHECK ADD  CONSTRAINT [FKo92933chkqfwhvni40h3yp5kp] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[wishlish] CHECK CONSTRAINT [FKo92933chkqfwhvni40h3yp5kp]
GO
