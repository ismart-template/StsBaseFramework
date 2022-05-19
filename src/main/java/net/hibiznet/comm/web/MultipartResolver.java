package net.hibiznet.comm.web;

/*
 * Copyright 2001-2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the ";License&quot;);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS"; BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * �떎�뻾�솚寃쎌쓽 �뙆�씪�뾽濡쒕뱶 泥섎━瑜� �쐞�븳 湲곕뒫 �겢�옒�뒪
 *
 * @author 怨듯넻�꽌鍮꾩뒪媛쒕컻�� �씠�궪�꽠
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *
 *  �닔�젙�씪                �닔�젙�옄             �닔�젙�궡�슜
 *  ----------   --------    ---------------------------
 *  2009.03.25   �씠�궪�꽠              理쒖큹 �깮�꽦
 *  2011.06.11   �꽌以��떇              �뒪�봽留� 3.0 �뾽洹몃젅�씠�뱶 API蹂�寃쎌쑝濡쒖씤�븳 �닔�젙
 *  2020.10.27   �떊�슜�샇              �삁�쇅泥섎━ �닔�젙
 *  2020.10.29   �떊�슜�샇              �뿀�슜�릺吏� �븡�뒗 �솗�옣�옄 �뾽濡쒕뱶 �젣�븳 (globals.properties > Globals.fileUpload.Extensions)
 *
 *      </pre>
 */
public class MultipartResolver extends CommonsMultipartResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultipartResolver.class);

	public MultipartResolver() {
	}

	/**
	 * 泥⑤��뙆�씪 泥섎━瑜� �쐞�븳 multipart resolver瑜� �깮�꽦�븳�떎.
	 *
	 * @param servletContext
	 */
	public MultipartResolver(ServletContext servletContext) {
		super(servletContext);
	}

	/**
	 * multipart�뿉 ���븳 parsing�쓣 泥섎━�븳�떎.
	 */
	@Override
	protected MultipartParsingResult parseFileItems(List<FileItem> fileItems, String encoding) {

		// �뒪�봽留� 3.0蹂�寃쎌쑝濡� �닔�젙�븳 遺�遺�
		MultiValueMap<String, MultipartFile> multipartFiles = new LinkedMultiValueMap<String, MultipartFile>();
		Map<String, String[]> multipartParameters = new HashMap<String, String[]>();
		//String whiteListFileUploadExtensions = EgovProperties.getProperty("Globals.fileUpload.Extensions");
		String whiteListFileUploadExtensions = "";
		Map<String, String> mpParamContentTypes = new HashMap<String, String>();

		// Extract multipart files and multipart parameters.
		for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext();) {
			FileItem fileItem = it.next();

			if (fileItem.isFormField()) {

				String value = null;
				if (encoding != null) {
					try {
						value = fileItem.getString(encoding);
					} catch (UnsupportedEncodingException ex) {
						LOGGER.warn("Could not decode multipart item '{}' with encoding '{}': using platform default",
								fileItem.getFieldName(), encoding);
						value = fileItem.getString();
					}
				} else {
					value = fileItem.getString();
				}
				String[] curParam = multipartParameters.get(fileItem.getFieldName());
				if (curParam == null) {
					// simple form field
					multipartParameters.put(fileItem.getFieldName(), new String[] { value });
				} else {
					// array of simple form fields
					String[] newParam = StringUtils.addStringToArray(curParam, value);
					multipartParameters.put(fileItem.getFieldName(), newParam);
				}

				//contentType �엯�젰
				mpParamContentTypes.put(fileItem.getFieldName(), fileItem.getContentType());
			} else {

//				CommonsMultipartFile file = createMultipartFile(fileItem);
//				multipartFiles.add(file.getName(), file);

//				LOGGER.debug("Found multipart file [{" + file.getName() + "}] of size {" + file.getSize()
//						+ "} bytes with original filename [{" + file.getOriginalFilename() + "}], stored {"
//						+ file.getStorageDescription() + "}");

				//String fileName = file.getOriginalFilename();
				String fileName = "";
				//String fileExtension = FileUploadUtil.getFileExtension(fileName);
				String fileExtension = "";
				LOGGER.debug("Found File Extension = "+fileExtension);
				if (whiteListFileUploadExtensions == null || "".equals(whiteListFileUploadExtensions)) {
					LOGGER.debug("The file extension whitelist has not been set.");
				} else {
					if (fileName == null || "".equals(fileName)) {
						LOGGER.debug("No file name.");
					} else {
						if ("".equals(fileExtension)) { // �솗�옣�옄 �뾾�뒗 寃쎌슦 泥섎━ 遺덇�
							throw new SecurityException("[No file extension] File extension not allowed.");
						}
						if ((whiteListFileUploadExtensions+".").contains("."+fileExtension.toLowerCase()+".")) {
							LOGGER.debug("File extension allowed.");
						} else {
							throw new SecurityException("["+fileExtension+"] File extension not allowed.");
						}
					}
				}

			}
		}

		return new MultipartParsingResult(multipartFiles, multipartParameters, mpParamContentTypes);//2022.01. Method call passes null for non-null parameter 泥섎━
	}
}
